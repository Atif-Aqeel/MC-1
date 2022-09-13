package com.atifaqeel.quranapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity2 extends AppCompatActivity {

    DrawerLayout dl;
    NavigationView nv;
    Toolbar tl;
    ActionBarDrawerToggle ad;
    Button Surah, Juz;
    ImageView i;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (ad.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Surah = findViewById(R.id.button3);
        Juz = findViewById(R.id.button2);
        i = findViewById(R.id.imageView3);

        Surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("index","Surah");
                startActivity(intent);
            }
        });

        Juz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                intent.putExtra("index1","Juzz");
                startActivity(intent);
            }
        });

        dl =findViewById(R.id.drawer_layout);
        nv =findViewById(R.id.navigationView);
        ad = new ActionBarDrawerToggle(this, dl, R.string.menu_Open, R.string.close_menu);
        dl.addDrawerListener(ad);
        ad.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        Log.i("Menu_Drawer_Tag","Home item is clicked");
                        dl.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_search:
                        Log.i("Menu_Drawer_Tag","Search item is clicked");
                        dl.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_profile:
                        Log.i("Menu_Drawer_Tag","Profile item is clicked");
                        dl.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_settings:
                        Log.i("Menu_Drawer_Tag","Settings item is clicked");
                        dl.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_share:
                        Log.i("Menu_Drawer_Tag","Share item is clicked");
                        dl.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }
}