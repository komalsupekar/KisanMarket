package com.komal.krypton.kisan.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ImageView karousel;


    int[] images = new int[]{ R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        karousel = findViewById(R.id.karousel);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbref = database.getReference("farmers");

        dbref.setValue("first farmer");


        Thread kthread = new Thread(){

            @Override
            public void run() {
                while (true)
                {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {

                        public String getImage(int imageId)
                        {
                            switch (imageId)
                            {
                                case R.drawable.c1:
                                    return "c1.png";

                                case R.drawable.c2:
                                    return "c2.png";


                                case R.drawable.c3:
                                    return "c3.png";


                                case R.drawable.c4:
                                    return "c4.png";


                                case R.drawable.c5:
                                    return "c5.png";


                                case R.drawable.c6:
                                    return "c6.png";


                                case R.drawable.c7:
                                    return "c7.png";


                                case R.drawable.c9:
                                    return "c9.png";


                                default:
                                    return "error??";

                            }
                        }

                        @Override
                        public void run() {
                            int randomImage, counter = 0;
                            Random random = new Random();
                            randomImage = images[random.nextInt(images.length)];
                            karousel.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade));
                            karousel.setImageResource(randomImage);

                            Log.d(TAG, "run: " + counter++);
                            Log.d(TAG, "image " + getImage(randomImage));
                        }
                    });
                }
            }
        };

        kthread.start();
    }


//---------------------------------------------------------------------------------------------------------------------------------------------------


}
