package com.example.lt1;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class APIInsert extends AsyncTask<String,String,String> {

    private Context context;


    public APIInsert(Context context)
    {
        this.context=context;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        return Run_URL(strings[0]);
    }

    private String Run_URL(String link)
    {
        StringBuilder sb=new StringBuilder();
        try {
            URL url=new URL(link);

            URLConnection urlConnection=url.openConnection();

            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while((line=bufferedReader.readLine())!=null)
            {
                sb.append(line);
            }
            bufferedReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
