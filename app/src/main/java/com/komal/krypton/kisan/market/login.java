package com.komal.krypton.kisan.market;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    EditText username,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.log);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid = username.getText().toString().trim().toLowerCase();
                if (!TextUtils.isEmpty(uid)&&!TextUtils.isEmpty(password.getText().toString())){
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("farmer",uid);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(),"please fill all the details",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
