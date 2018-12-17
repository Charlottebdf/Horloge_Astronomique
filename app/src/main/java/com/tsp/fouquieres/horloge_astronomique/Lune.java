package com.tsp.fouquieres.horloge_astronomique;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Lune extends AppCompatActivity {

    private Button button;

    //@RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lune);

            Button button = (Button)findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent queljour = new Intent(getApplicationContext(),LuneJour.class);
                    startActivity(queljour);
                }
            });

            //TextView julday = findViewById(R.id.julday);

            Date now = new Date();
            Calendar today = new GregorianCalendar();
            today.setTime(now);
            //julday.setText(new StringBuilder().append("jour julien : ").append(jourjulien(now)));

            ImageView imageView = (ImageView)findViewById(R.id.imageView);
            int dernierenouvellelune = 2458460;

            Bitmap phase_1 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_1);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 0){
                imageView.setImageBitmap(phase_1);
            }
            Bitmap phase_2 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_2);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 1) {
                imageView.setImageBitmap(phase_2);
            }
            Bitmap phase_3 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_3);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 2) {
                imageView.setImageBitmap(phase_3);
            }
            Bitmap phase_4 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_4);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 3) {
                imageView.setImageBitmap(phase_4);
            }
            Bitmap phase_5 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_5);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 4) {
                imageView.setImageBitmap(phase_5);
            }
            Bitmap phase_6 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_6);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 5) {
                imageView.setImageBitmap(phase_5);
            }
            Bitmap phase_7 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_7);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 6) {
                imageView.setImageBitmap(phase_6);
            }
            Bitmap phase_8 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_8);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 7) {
                imageView.setImageBitmap(phase_8);
            }
            Bitmap phase_9 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_9);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 8) {
                imageView.setImageBitmap(phase_8);
            }
            Bitmap phase_10 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_10);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 9) {
                imageView.setImageBitmap(phase_10);
            }
            Bitmap phase_11 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_11);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 10) {
                imageView.setImageBitmap(phase_11);
            }
            Bitmap phase_12 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_12);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 11) {
                imageView.setImageBitmap(phase_12);
            }
            Bitmap phase_13 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_13);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 12) {
                imageView.setImageBitmap(phase_13);
            }
            Bitmap phase_14 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_14);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 13) {
                imageView.setImageBitmap(phase_14);
            }
            Bitmap phase_15 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_15);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 14) {
                imageView.setImageBitmap(phase_15);
            }
            Bitmap phase_16 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_16);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 15) {
                imageView.setImageBitmap(phase_16);
            }
            Bitmap phase_17 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_17);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 16) {
                imageView.setImageBitmap(phase_17);
            }
            Bitmap phase_18 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_18);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 17) {
                imageView.setImageBitmap(phase_18);
            }
            Bitmap phase_19 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_19);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 18) {
                imageView.setImageBitmap(phase_19);
            }
            Bitmap phase_20 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_20);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 19) {
                imageView.setImageBitmap(phase_20);
            }
            Bitmap phase_21 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_21);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 20) {
                imageView.setImageBitmap(phase_21);
            }
            Bitmap phase_22 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_22);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 21) {
                imageView.setImageBitmap(phase_22);
            }
            Bitmap phase_23 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_23);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 22) {
                imageView.setImageBitmap(phase_23);
            }
            Bitmap phase_24 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_24);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 23) {
                imageView.setImageBitmap(phase_24);
            }
            Bitmap phase_25 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_25);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 24) {
                imageView.setImageBitmap(phase_25);
            }
            Bitmap phase_26 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_26);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 25) {
                imageView.setImageBitmap(phase_26);
            }
            Bitmap phase_27 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_27);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 26) {
                imageView.setImageBitmap(phase_27);
            }
            Bitmap phase_28 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_28);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 27) {
                imageView.setImageBitmap(phase_28);
            }
            Bitmap phase_29 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_29);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 28) {
                imageView.setImageBitmap(phase_29);
            }
            Bitmap phase_30 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_30);
            if ((jourjulien(now) - dernierenouvellelune)%30 == 29) {
                imageView.setImageBitmap(phase_30);
            }

        }

        static double jourjulien(Date now){

            long secondes_jour = 86400000;
            double jul = 21086676E7;
            return Math.round((now.getTime() + jul)/secondes_jour);
        }

}




