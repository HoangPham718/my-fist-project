package com.example.notemag;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity{
public final String path="http://192.168.1.92/api/api.php";
private static LinkedList<WordDict> mWordList=new LinkedList<WordDict>();
private RecyclerView recyclerView;
private WordListAdapter wordListAdapter;
private EditText txtTk;
private Button btnTK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GetData data=new GetData(MainActivity.this);
                data.execute(path);
                mWordList=data.getmWordList();
            }
        });


        recyclerView=findViewById(R.id.recycler);

        wordListAdapter=new WordListAdapter(this,mWordList);

        recyclerView.setAdapter(wordListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,secondActivity.class);
                startActivity(intent);
            }
        });

        btnTK= findViewById(R.id.btnTK);
        txtTk=findViewById(R.id.txtTK);
        //Tìm kiếm
        btnTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinkedList<WordDict> result = new LinkedList<WordDict>();
                int dem = 0;
                int count = mWordList.size();
                for (int i = 0; i < count; i++) {
                    mWordList.get(i).toString().toLowerCase();
                    if (mWordList.get(i).toString().toLowerCase().indexOf(txtTk.getText().toString()) >= 0&&dem<11) {
                        result.addLast(mWordList.get(i));
                        dem++;
                    }
                }
                wordListAdapter = new WordListAdapter(getApplicationContext(), result);

                recyclerView.setAdapter(wordListAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}