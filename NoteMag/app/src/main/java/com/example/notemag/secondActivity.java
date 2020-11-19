package com.example.notemag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class secondActivity extends AppCompatActivity {
private Button btnBack;
private Button btnAdd;
private EditText edtWord;
private EditText edtDef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnBack=findViewById(R.id.btnBack);
        btnAdd=findViewById(R.id.btnAdd);
        edtWord=findViewById(R.id.edtWord);
        edtDef=findViewById(R.id.edtDef);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(secondActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int l=0;
                //kt word
                if(edtWord.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Không được bỏ trống từ",Toast.LENGTH_SHORT).show();
                    l=1;
                }
                if(edtWord.getText().toString().contains(" "))
                {
                    Toast.makeText(getApplicationContext(),"Không được điền khoảng trắng",Toast.LENGTH_SHORT).show();
                    l=1;
                }
                //kt định nghĩa
                if (edtDef.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Phần định nghĩa không được bỏ trống", Toast.LENGTH_LONG).show();
                }
                    int count = 0;
                    char space;
                    for (int i = 0; i < edtDef.getText().toString().length(); i++)
                    {
                        space = edtDef.getText().toString().charAt(i);
                        if (Character.isSpaceChar(space))
                            count++;
                    }

                    if(count < 2)
                        Toast.makeText(getApplicationContext(), "Phần định nghĩa ít nhất 3 từ", Toast.LENGTH_LONG).show();
              /*  if(l!=1)
                {
                    InputStream is= getApplicationContext().getResources().openRawResource(R.raw.dictionary);
                    BufferedReader br=new BufferedReader(new InputStreamReader(is));
                    StringBuilder sb= new StringBuilder();
                    String s=null;
                    while(true) {
                        try{
                            if(!((s=br.readLine())!=null))break;
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                        sb.append(s);
                        sb.append("\n");
                    }

                    try {
                        JSONObject jsonObject=new JSONObject(sb.toString());
                        JSONObject jsonObj=new JSONObject();
                        JSONObject jObj=new JSONObject();
                        jsonObj.put("word", edtWord.getText().toString());
                        jsonObj.put("definition", edtDef.getText().toString());
                        JSONArray jsonArray=jsonObject.getJSONArray("ds");
                        jsonArray.put(jsonObj);
                        Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

               */
            }
        });
    }
}