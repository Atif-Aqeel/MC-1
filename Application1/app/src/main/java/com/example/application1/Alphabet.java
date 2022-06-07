package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Alphabet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alphabet_main);

        String des_text;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            des_text = bundle.getString("description_text");
            TextView desc = findViewById(R.id.desc);
            desc.setText(des_text);
            ImageView img = findViewById(R.id.img);
            int resID = bundle.getInt("resId");
            img.setImageResource(resID);
        }


        Button bckBtn = findViewById(R.id.backBtn);
        bckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Alphabet.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }
}