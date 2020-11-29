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
private final String pathInsert="http://192.168.1.92/api/insert.php";

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
                String word=edtWord.getText().toString();
                String def=edtDef.getText().toString();
                //kt word
                if(word.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Không được bỏ trống từ",Toast.LENGTH_SHORT).show();
                    l=1;
                }
                if(word.contains(" "))
                {
                    Toast.makeText(getApplicationContext(),"Không được điền khoảng trắng",Toast.LENGTH_SHORT).show();
                    l=1;
                }
                //kt định nghĩa
                if (def.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Phần định nghĩa không được bỏ trống", Toast.LENGTH_LONG).show();
                    l=1;
                }

//                int count = 0;
//                char space;
//                for (int i = 0; i < def.toString().length(); i++)
//                {
//                    space = def.toString().charAt(i);
//                    if (Character.isSpaceChar(space))
//                        count++;
//                }
//                if(count < 2)
//                {
//                    Toast.makeText(getApplicationContext(), "Phần định nghĩa ít nhất 3 từ", Toast.LENGTH_LONG).show();
//                    l=1;
//                }

                //thêm vào
                if(l!=1) {
                    WordDict newWord= new WordDict(word,def);
                            new InsertData(getApplicationContext(),newWord,"1",0).execute(pathInsert);
                }
            }
        });
    }
}