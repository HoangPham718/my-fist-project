package com.example.api_st;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;

public class APIGetting extends AsyncTask<String,String,String> {
    private Activity m_con;
    public  APIGetting(Activity con)
    {
        m_con =con;
        String result;
    }

    @Override
    protected String doInBackground(String... level) {
        return APIQuestion.getQuestions(level[0]);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }

}
