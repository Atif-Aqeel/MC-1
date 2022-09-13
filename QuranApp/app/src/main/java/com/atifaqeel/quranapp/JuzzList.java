package com.atifaqeel.quranapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.atifaqeel.islamiculoom.tasreefapp.Common.QuranData.QDH;
import com.atifaqeel.islamiculoom.tasreefapp.Common.QuranData.QuranArabicText;

import java.util.List;

public class JuzzList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juzz_list);

        Intent intent=getIntent();
        int i=intent.getIntExtra("position",0);

        QDH qdh=new QDH();
        int start=qdh.getParahStart(i);
        int end=qdh.getParahStart(i+1);

        QuranArabicText quranArabicText=new QuranArabicText();
        List<String> ayat=quranArabicText.GetSurahAyats(start,end-1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(JuzzList.this, android.R.layout.simple_list_item_1, ayat);
        ListView listView = findViewById(R.id.list1);
        listView.setAdapter(arrayAdapter);
    }
}