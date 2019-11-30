package com.komal.krypton.kisan.market;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class dashboard extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ImageView karousel;
    Button add, view;

    String farmerName;

    int[] images = new int[]{ R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);

        karousel = findViewById(R.id.karousel);


        Thread kthread = new Thread(){
            public int counter = 0;

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
                            int randomImage;
                            Random random = new Random();
                            randomImage = images[random.nextInt(images.length)];
                            karousel.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade));
                            karousel.setImageResource(randomImage);

                            Log.d(TAG, "run: " +counter++);
                            Log.d(TAG, "image " + getImage(randomImage));
                        }
                    });
                }
            }
        };
        kthread.start();
    }


//---------------------------------------------------------------------------------------------------------------------------------------------------


        public void add(View view)
        {
            farmerName = getIntent().getExtras().getString("farmer");
            Intent i = new Intent(getApplicationContext(),addItems.class);
            i.putExtra("farmer",farmerName);
            i.putExtra("city","pune");
            Log.d(TAG, "add: farmer :" +farmerName);
            startActivity(i);
        }


        public void show(View view)
        {

        }


}
