package com.tsp.fouquieres.horloge_astronomique;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class SoleilJour extends AppCompatActivity {

    private DatePicker jour;
    private TextView autrejour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soleil_jour);

        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Fournisseurs de service
                LocationManager manager =
                        (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                List<String> fournisseurs = manager.getAllProviders();
                for (String f : fournisseurs)
                    Toast.makeText(getApplicationContext(), "" + f,
                            Toast.LENGTH_SHORT).show();

// Récupération de la localisation
                if (ActivityCompat.checkSelfPermission(SoleilJour.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(SoleilJour.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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

                    double longitude = localisation.getLongitude();
                    double latitude = localisation.getLatitude();

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

                                if (ActivityCompat.checkSelfPermission(SoleilJour.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(SoleilJour.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
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

                                    double longitude = localisation.getLongitude();
                                    double latitude = localisation.getLatitude();

                                }
                            }
                        });

                double longitude = localisation.getLongitude();
                double latitude = localisation.getLatitude();
                autrejour = (TextView)findViewById(R.id.autrejour);
                jour = (DatePicker)findViewById(R.id.jour);
                int j = jour.getDayOfMonth();
                int m = jour.getMonth();
                int a = jour.getYear();
                Calendar choisie = new GregorianCalendar();
                choisie.set(a,m,j);
                AsyncTaskSoleilJour task = new AsyncTaskSoleilJour(SoleilJour.this);
                task.execute("http://vo.imcce.fr/webservices/miriade/rts_query.php?-ep="+jourjulien(choisie)+"&-body=11&-long="+longitude+"&-lat="+latitude+"&-body=11&-mime=text");


            }
        });

            }

    static double jourjulien(Calendar choisie){

        long secondes_jour = 86400000;
        double jul = 21086676E7;
        return Math.round((choisie.getTimeInMillis() + jul)/secondes_jour);
    }
}
