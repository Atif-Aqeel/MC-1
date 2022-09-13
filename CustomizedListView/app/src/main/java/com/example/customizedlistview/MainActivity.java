package com.example.customizedlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Name(Apple)", "001", "Section(A)","Degree(SE)", R.drawable.a));
        studentArrayList.add(new Student("Balloon", "002", "bee", "Beer",R.drawable.b));
        studentArrayList.add(new Student("Cat", "003", "Carrot", "Dog",R.drawable.c));
        studentArrayList.add(new Student("Donkey", "004", "dog","Drum", R.drawable.d));
        studentArrayList.add(new Student("Elephant", "004", "Eye","Egg", R.drawable.e));
        MyViewAdapter adapter = new MyViewAdapter(this, studentArrayList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);



    }
}