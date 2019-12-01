package com.komal.krypton.kisan.market;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class showProducts extends AppCompatActivity {
    private static final String TAG = "showProducts";
    ListView lv;
    ArrayList<String> farmers = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_products);



        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference();

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterator iterator = dataSnapshot.getChildren().iterator();

                while (iterator.hasNext())
                {
                    farmers.add(dataSnapshot.getValue().toString());
                    Log.d(TAG, "onDataChange: " +dataSnapshot.getValue());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        lv = findViewById(R.id.products);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.activity_show_products,farmers);

        lv.setAdapter(adapter);

    }
}
