package com.example.lt1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class ThemTu extends AppCompatActivity {
private EditText edtTu;
private EditText edtDn;
private Button btnAdd;
private Button btnBack;
final String urlAdd="http://192.168.1.3/apilt1/insert.php?tu=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_tu);

        edtTu=findViewById(R.id.edtTu);
        edtDn=findViewById(R.id.edtDn);
        btnAdd=findViewById(R.id.btnAdd);
        btnBack=findViewById(R.id.btnBack);

    }

    public void ThemTu(View view) throws ExecutionException, InterruptedException {
        String tu=edtTu.getText().toString();
        String dn=edtDn.getText().toString();
        if(tu.isEmpty()||dn.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Không dược bỏ trống",Toast.LENGTH_SHORT).show();
        }
        else
        {
            APIInsert api=new APIInsert(getApplicationContext());
            api.execute(urlAdd+tu+"&dn="+dn);
            String result =api.get();
            if(result.equals("success"))
            {
                Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(getApplicationContext(),"Thêm thất bại",Toast.LENGTH_SHORT).show();
        }
    }

    public void Home(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
        this.startActivity(intent);
        finish();
    }
}