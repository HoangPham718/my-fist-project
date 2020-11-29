package com.example.notemag;

import android.app.Activity;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class InsertData extends AsyncTask<String,String,String> {
    private Context context;
    private String  kq=null;
    private WordDict wordDict;
    private String id;
    private int verb;

    public InsertData(Context context, WordDict wordDict, String id, int verb) {
        this.context = context;
        this.wordDict = wordDict;
        this.id = id;
        this.verb = verb;
    }

    @Override
    protected String doInBackground(String... strings) {

        RequestQueue requestQueue= Volley.newRequestQueue(context);
        //lỗi
        StringRequest stringRequest=new StringRequest(Request.Method.POST, strings[0], new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("true"))
                    kq="true";
                else
                    kq="false";
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                kq="false";
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("id",id);
                params.put("word",wordDict.getWord());
                params.put("def",wordDict.getDef());
                params.put("verb", (Integer.toString(verb)));
                return params;
            }
        };
        requestQueue.add(stringRequest);
        return kq;
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s.equals("true"))
        {
            Toast.makeText(context,"Thêm thành công",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(context,"Thất bại",Toast.LENGTH_SHORT).show();
    }


}
