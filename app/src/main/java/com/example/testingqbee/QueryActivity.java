package com.example.testingqbee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class QueryActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);


    }
    public void openActivity2(){
        Intent intent = new Intent(this,settingsActivity.class);
        startActivity(intent);
        //finish();
    }

    public void openQueryActivity() {
        Intent intent = new Intent(this, QueryActivity.class);
        startActivity(intent);
        //finish();
    }
}