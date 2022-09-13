package com.atifaqeel.quranapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.atifaqeel.islamiculoom.tasreefapp.Common.QuranData.QDH;
import com.atifaqeel.islamiculoom.tasreefapp.Common.QuranData.QuranArabicText;

import java.util.List;

public class SurahList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_list);

        Intent intent=getIntent();
        int i=intent.getIntExtra("position",0);
        Log.d("test", "you click in surahList : " + i);

        QDH qdh=new QDH();
        int start=qdh.getSurahStart(i);
        int end=qdh.getSurahStart(i+1);

        QuranArabicText quranArabicText=new QuranArabicText();
        List<String> ayat=quranArabicText.GetSurahAyats(start-1,end-1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SurahList.this, android.R.layout.simple_list_item_1, ayat);
        ListView listView = findViewById(R.id.list1);
        listView.setAdapter(arrayAdapter);
    }
}