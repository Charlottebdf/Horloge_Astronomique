package com.tsp.fouquieres.horloge_astronomique;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button soleil;
    private Button lune;
    private TextView hello;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soleil = (Button) findViewById(R.id.soleil);
        lune = (Button) findViewById(R.id.lune);
        hello = (TextView) findViewById(R.id.hello);

        soleil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(getApplicationContext(), Soleil.class);
                startActivity(s);
            }
        });

        lune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent l = new Intent(getApplicationContext(), Lune.class);
                startActivity(l);
            }
        });



        hello.setText(new StringBuilder().append("Hello, besoin d'informations sur la Lune ou le Soleil?"));



    }

}



