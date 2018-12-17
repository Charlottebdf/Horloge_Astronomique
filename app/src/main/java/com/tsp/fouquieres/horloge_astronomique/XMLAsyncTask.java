package com.tsp.fouquieres.horloge_astronomique;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;


public class XMLAsyncTask extends AsyncTask<String, Void, String>{
    private AppCompatActivity myActivity;

    public XMLAsyncTask (AppCompatActivity mainActivity) {
        myActivity = mainActivity;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... strings) {

        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        URL url = null;
        HttpURLConnection urlConnection = null;
        String result = null;
        try {
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection(); // Open
            InputStream in = new BufferedInputStream(urlConnection.getInputStream()); // Stream

            result = readStream(in); // Read stream
        }
        catch (MalformedURLException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        finally { if (urlConnection != null)
            urlConnection.disconnect();  }

        return result; // returns the result
    }

    @Override
    protected void onPostExecute(String s) {

        StringTokenizer st = new StringTokenizer(s,",");
        String lever = st.nextToken();
        int i = 1;
        while(i != 16){
            lever = st.nextToken();
            i++;
        }
        StringTokenizer st2 = new StringTokenizer(s,",");
        String coucher = st.nextToken();
        int j= 1;
        while (j != 26){
            coucher=st2.nextToken();
            j++;
        }

        TextView dat = (TextView) myActivity.findViewById(R.id.dat);
        dat.setText("Aujourd'hui, le Soleil se lève à " + lever + "\n" + "et il se couche à " + coucher);

    }

    private String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
        for (String line = r.readLine(); line != null; line =r.readLine()){
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }


}