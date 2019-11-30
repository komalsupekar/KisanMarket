package com.komal.krypton.kisan.market;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class addItems extends AppCompatActivity {
    EditText items,qty;
    String farmerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);
    }

    class farmer {
        public String qty,item;

        farmer(String item,String qty) {
            this.item = item;
            this.qty = qty;
        }
    }


    public void add(View view)
    {
        items = findViewById(R.id.item);
        qty = findViewById(R.id.qty);

        farmerName = getIntent().getExtras().getString("farmer");

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbref = database.getReference("markets");

        farmer f1 = new farmer(items.getText().toString().trim(),qty.getText().toString().trim());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String date = sdf.format(new Date().getTime());
        String market = getIntent().getExtras().getString("city");

        dbref.child(market).child(date).child(farmerName).setValue(f1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getApplicationContext(),"Data submitted successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
