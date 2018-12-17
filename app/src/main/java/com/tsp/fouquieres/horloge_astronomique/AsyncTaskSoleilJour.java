package com.tsp.fouquieres.horloge_astronomique;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
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

public class AsyncTaskSoleilJour extends AsyncTask<String, Void, String> {
    private AppCompatActivity myActivity;

    public AsyncTaskSoleilJour (AppCompatActivity mainActivity) {
        myActivity = mainActivity;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... strings) {
        //publishProgress(1);
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        URL url = null;
        HttpURLConnection urlConnection = null;
        String result = null;
        try {
            url = new URL(strings[0]);
            urlConnection = (HttpURLConnection) url.openConnection(); // Open
            InputStream in = new BufferedInputStream(urlConnection.getInputStream()); // Stream
            //publishProgress(2);
            result = readStream(in); // Read stream
        }
        catch (MalformedURLException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
        finally { if (urlConnection != null)
            urlConnection.disconnect();  }

        // publishProgress(4);
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
        String coucher = st2.nextToken();
        int j = 1;
        while (j != 25){
            coucher = st2.nextToken();
            j++;
        }

        TextView autrejour = (TextView) myActivity.findViewById(R.id.autrejour);
        //dat.setText(""+s.charAt(5)); // Updates the textview
        autrejour.setText("Ce jour-là, le Soleil se lève à " + lever + "\n" + "et il se couche à " + coucher);


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
