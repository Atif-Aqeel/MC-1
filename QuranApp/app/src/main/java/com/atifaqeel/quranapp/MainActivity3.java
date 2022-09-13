package com.atifaqeel.quranapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.atifaqeel.islamiculoom.tasreefapp.Common.QuranData.QDH;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        QDH qdh=new QDH();
        Intent intent=getIntent();
        String index=intent.getStringExtra("index");

        if(index.equals("Surah"))
        {
            ListView listView = findViewById(R.id.list);
            List<String> list = qdh.GetAllSurahNames();
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity3.this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(MainActivity3.this, SurahList.class);
                    Log.d("test", "you click in menu : " + i);
                    intent.putExtra("position", i);
                    startActivity(intent);
               }
            });
        }
    }
}