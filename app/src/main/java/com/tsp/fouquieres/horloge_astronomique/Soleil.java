package com.tsp.fouquieres.horloge_astronomique;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Soleil extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soleil);

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent unautrejour = new Intent(getApplicationContext(),SoleilJour.class);
                startActivity(unautrejour);
            }
        });


// Fournisseurs de service
LocationManager manager =
        (LocationManager) getSystemService(Context.LOCATION_SERVICE);
List<String> fournisseurs = manager.getAllProviders();
for (String f : fournisseurs)
    Toast.makeText(getApplicationContext(), "" + f,
            Toast.LENGTH_SHORT).show();

// Récupération de la localisation
if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
    // TODO: Consider calling
    //    ActivityCompat#requestPermissions
    // here to request the missing permissions, and then overriding
    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
    //                                          int[] grantResults)
    // to handle the case where the user grants the permission. See the documentation
    // for ActivityCompat#requestPermissions for more details.
    return;
}
Location localisation = manager.getLastKnownLocation("gps");
if (localisation != null) {
    //longlat = (TextView) findViewById(R.id.longlat);
    double longitude = localisation.getLongitude();
    double latitude = localisation.getLatitude();
    //longlat.setText(new StringBuilder().append("longitude"));
}

//Toast.makeText(getApplicationContext(), "Lattitude" +
//        localisation.getLatitude(), Toast.LENGTH_SHORT).show();
//Toast.makeText(getApplicationContext(), "Longitude" +
//        localisation.getLongitude(), Toast.LENGTH_SHORT).show();

// Ecouteur de changement de localisation
manager.requestLocationUpdates("gps", 6000, 100,
        new LocationListener() {
            public void onStatusChanged(String provider,
                                        int status, Bundle extras) {
            }
            public void onProviderEnabled(String provider) {
            }
            public void onProviderDisabled(String provider) {
            }
            public void onLocationChanged(Location location) {
                // TODO Auto-generated method stub
                LocationManager manager =
                        (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                if (ActivityCompat.checkSelfPermission(Soleil.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Soleil.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }

                Location localisation = manager.getLastKnownLocation("gps");
                if (localisation != null) {
                    //longlat = (TextView) findViewById(R.id.longlat);
                    double longitude = localisation.getLongitude();
                    double latitude = localisation.getLatitude();
                    //longlat.setText(new StringBuilder().append("longitude : ").append(longitude).append("\n").append("latitude : ").append(latitude));
                }
            }
        });



        XMLAsyncTask task = new XMLAsyncTask(Soleil.this);

        Date now = new Date();
        
        double longitude = localisation.getLongitude();
        double latitude = localisation.getLatitude();
        task.execute("http://vo.imcce.fr/webservices/miriade/rts_query.php?-ep="+jourjulien(now)+"&-body=11&-long="+longitude+"&-lat="+latitude+"&-mime=text");


    }
    static double jourjulien (Date now){

        long secondes_jour = 86400000;
        double jul = 21086676E7;
        return Math.round((now.getTime() + jul) / secondes_jour);
    }

}






















