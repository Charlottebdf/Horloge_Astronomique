package com.tsp.fouquieres.horloge_astronomique;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LuneJour extends AppCompatActivity {

    private DatePicker jour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lune_jour);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jour = (DatePicker)findViewById(R.id.jour);
                int j = jour.getDayOfMonth();
                int m = jour.getMonth();
                int a = jour.getYear();

                Calendar choisie = new GregorianCalendar();
                choisie.set(a,m,j);


                ImageView imageView2 = (ImageView)findViewById(R.id.imageView2);
                int dernierenouvellelune = 2458460;

                Bitmap phase_1 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_1);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 0){
                    imageView2.setImageBitmap(phase_1);
                }
                Bitmap phase_2 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_2);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 1) {
                    imageView2.setImageBitmap(phase_2);
                }
                Bitmap phase_3 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_3);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 2) {
                    imageView2.setImageBitmap(phase_3);
                }
                Bitmap phase_4 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_4);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 3) {
                    imageView2.setImageBitmap(phase_4);
                }
                Bitmap phase_5 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_5);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 4) {
                    imageView2.setImageBitmap(phase_5);
                }
                Bitmap phase_6 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_6);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 5) {
                    imageView2.setImageBitmap(phase_5);
                }
                Bitmap phase_7 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_7);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 6) {
                    imageView2.setImageBitmap(phase_6);
                }
                Bitmap phase_8 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_8);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 7) {
                    imageView2.setImageBitmap(phase_8);
                }
                Bitmap phase_9 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_9);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 8) {
                    imageView2.setImageBitmap(phase_8);
                }
                Bitmap phase_10 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_10);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 9) {
                    imageView2.setImageBitmap(phase_10);
                }
                Bitmap phase_11 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_11);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 10) {
                    imageView2.setImageBitmap(phase_11);
                }
                Bitmap phase_12 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_12);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 11) {
                    imageView2.setImageBitmap(phase_12);
                }
                Bitmap phase_13 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_13);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 12) {
                    imageView2.setImageBitmap(phase_13);
                }
                Bitmap phase_14 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_14);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 13) {
                    imageView2.setImageBitmap(phase_14);
                }
                Bitmap phase_15 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_15);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 14) {
                    imageView2.setImageBitmap(phase_15);
                }
                Bitmap phase_16 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_16);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 15) {
                    imageView2.setImageBitmap(phase_16);
                }
                Bitmap phase_17 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_17);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 16) {
                    imageView2.setImageBitmap(phase_17);
                }
                Bitmap phase_18 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_18);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 17) {
                    imageView2.setImageBitmap(phase_18);
                }
                Bitmap phase_19 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_19);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 18) {
                    imageView2.setImageBitmap(phase_19);
                }
                Bitmap phase_20 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_20);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 19) {
                    imageView2.setImageBitmap(phase_20);
                }
                Bitmap phase_21 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_21);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 20) {
                    imageView2.setImageBitmap(phase_21);
                }
                Bitmap phase_22 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_22);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 21) {
                    imageView2.setImageBitmap(phase_22);
                }
                Bitmap phase_23 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_23);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 22) {
                    imageView2.setImageBitmap(phase_23);
                }
                Bitmap phase_24 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_24);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 23) {
                    imageView2.setImageBitmap(phase_24);
                }
                Bitmap phase_25 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_25);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 24) {
                    imageView2.setImageBitmap(phase_25);
                }
                Bitmap phase_26 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_26);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 25) {
                    imageView2.setImageBitmap(phase_26);
                }
                Bitmap phase_27 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_27);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 26) {
                    imageView2.setImageBitmap(phase_27);
                }
                Bitmap phase_28 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_28);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 27) {
                    imageView2.setImageBitmap(phase_28);
                }
                Bitmap phase_29 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_29);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 28) {
                    imageView2.setImageBitmap(phase_29);
                }
                Bitmap phase_30 = BitmapFactory.decodeResource(getResources(),R.drawable.phase_30);
                if ((jourjulien(choisie) - dernierenouvellelune)%30 == 29) {
                    imageView2.setImageBitmap(phase_30);
                }


            };

            });
        };
    static double jourjulien(Calendar choisie){

        long secondes_jour = 86400000;
        double jul = 21086676E7;
        return Math.round((choisie.getTimeInMillis() + jul)/secondes_jour);
    }




    }

