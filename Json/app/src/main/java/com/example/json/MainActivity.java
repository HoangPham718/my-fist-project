package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText outputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void runExample(View view){
        outputText = (EditText)findViewById(R.id.txt_text);
        try{
            //Đọc file: res/raw/company.json và trả về đối tượng Company.
            Company company = ReadJSONExample.ReadCompanyJSONFile(this);
            outputText.setText(company.toString());
        }catch (Exception e){
            outputText.setText(e.getMessage());
            e.printStackTrace();
        }
    }
}