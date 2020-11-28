package com.example.api_st;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIQuestion {
    static String getQuestions(String Level){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String result = null;
        try {
            URL requestURL = new URL("http://192.168.1.92/api/api.php?DoKho="+Level);
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            //lỗi
            urlConnection.connect();
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            String jSon=null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            jSon=builder.toString();
            try {
                JSONArray jr = new JSONArray(jSon);
                JSONObject jb = (JSONObject) jr.getJSONObject(0);
                String nd = jb.getString("NoiDung");
                String da1 = jb.getString("DapAn1");
                String da2 = jb.getString("DapAn2");
                String da3 = jb.getString("DapAn3");
                String da4 = jb.getString("DapAn4");
                String daD = jb.getString("DA_Dung");
                result=nd+"--"+da1+"--"+da2+"--"+da3+"--"+da4+"--"+daD;
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

            if (builder.length() == 0) {
                return null;
            }
            result = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
