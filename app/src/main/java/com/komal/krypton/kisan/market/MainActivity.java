package com.komal.krypton.kisan.market;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//---------------------------------------------------------------------------------------------------------------------------------------------------
        // TODO: 12/1/19
        //  add cities and their specialities dynamically
        String[] cities = {"Pune", "Mahabaleshwar", "Nagpur","Mumbai","Nashik"};


        int[] images = {R.drawable.pune, R.drawable.strawberry, R.drawable.nagpur, R.drawable.mumbai,R.drawable.grapes};

        citygenerator tbd = new citygenerator(getApplicationContext(), images, cities);

        ListView lv = findViewById(R.id.list);

        lv.setAdapter(tbd);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = view.findViewById(R.id.cityname);
                Toast.makeText(getApplicationContext(),tv.getText().toString(),Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),dashboard.class);
                switch (tv.getText().toString().trim().toLowerCase()){
                    case "pune":
                        i.putExtra("city","pune");
                        startActivity(i);
                        break;

                    case "mumbai":
                        i.putExtra("city","mumbai");
                        startActivity(i);
                        break;

                    case "nagpur":
                        i.putExtra("city","nagpur");
                        startActivity(i);
                        break;


                    case "nashik":
                        i.putExtra("city","nashik");
                        startActivity(i);
                        break;


                    case "mahabaleshwar":
                        i.putExtra("city","mahabaleshwar");
                        startActivity(i);
                        break;
                    }
                }
        });
    }
}
