package com.example.lt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
private final String urlData="http://192.168.1.3/apilt1/api.php";
private final String urlSearch="http://192.168.1.3/apilt1/Timkiem.php?Tim=";

private RecyclerView recyclerView;
private TuVungAdapter tuVungAdapter;
private EditText tukhoa;
private Button btnTimKiem;
private Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);
        tukhoa=findViewById(R.id.txtTuKhoa);
        btnTimKiem=findViewById(R.id.btnTimKiem);
        btnThem=findViewById(R.id.btnThem);

        LinkedList<TuVung> mListTu=new LinkedList<>();
        API api=new API(this);

        api.execute(urlData);
        mListTu=api.getmListTu();

        tuVungAdapter=new TuVungAdapter(this,mListTu);
        recyclerView.setAdapter(tuVungAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void Search(View view) {
        String tu=tukhoa.getText().toString();
        tu=tu.replaceAll("\\s","");
        tukhoa.setText(tu);
        if(tu.length()<3)
        {
            Toast.makeText(getApplicationContext(),"Từ khóa phải có 3 kí tự trở lên",Toast.LENGTH_SHORT).show();
        }
        else
        {
            LinkedList<TuVung> mListTu=new LinkedList<>();
            API api=new API(getApplicationContext());

            api.execute(urlSearch+tu);
            mListTu=api.getmListTu();

            tuVungAdapter=new TuVungAdapter(getApplicationContext(),mListTu);
            recyclerView.setAdapter(tuVungAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        }
    }

    public void Add(View view) {
        this.startActivity(new Intent(this,ThemTu.class));
    }
}