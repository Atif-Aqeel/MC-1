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

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        QDH qdh=new QDH();
        Intent intent=getIntent();
        String index=intent.getStringExtra("index1");

        if (index.equals("Juzz")) {
            ListView listView = findViewById(R.id.list2);
            List<String> list = qdh.GetAllParahNames();
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity4.this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(MainActivity4.this, JuzzList.class);
                    Log.d("test", "you click in menu : " + i);
                    intent.putExtra("position", i);
                    startActivity(intent);
                }
            });
        }
    }
}