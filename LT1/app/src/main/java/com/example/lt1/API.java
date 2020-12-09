package com.example.lt1;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

public class API extends AsyncTask<String,String,String> {

    LinkedList<TuVung> mListTu=new LinkedList<>();
    private Context context;


    public LinkedList<TuVung> getmListTu() {
        return mListTu;
    }

    public API(Context context)
    {
        this.context=context;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try{
            JSONArray jsonArray=new JSONArray(s);
            int lenght=jsonArray.length();
            for(int i=0;i<lenght;i++)
            {
                TuVung tuVung= new TuVung(jsonArray.getJSONObject(i).getString("TuVung"),jsonArray.getJSONObject(i).getString("DinhNghia"));
                mListTu.addLast(tuVung);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
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
                sb.append("\n");
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
