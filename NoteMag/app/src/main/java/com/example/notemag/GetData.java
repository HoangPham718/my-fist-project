package com.example.notemag;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.notemag.WordDict;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

public class GetData extends AsyncTask<String,String,String> {

    private Activity activity;

    public LinkedList<WordDict> getmWordList() {
        return mWordList;
    }

    private LinkedList<WordDict> mWordList=new LinkedList<WordDict>();
    public GetData(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try{
            JSONArray jsonArray=new JSONArray(s);
            int lenght=jsonArray.length();
            for(int i=0;i<lenght;i++)
            {
                WordDict word= new WordDict(jsonArray.getJSONObject(i).getString("word"),jsonArray.getJSONObject(i).getString("definition"));
                    mWordList.addLast(word);
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    protected String doInBackground(String... strings) {

        return docNoiDung_Tu_URL(strings[0]);
    }

    private String docNoiDung_Tu_URL(String theUrl){
        StringBuilder content = new StringBuilder();
        try    {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return content.toString();
    }
}
