package com.example.testingqbee;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static TaxiDatabase myAppDatabase;
    public static FirebaseFirestore db;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.Theme_Dark);
        } else {
            setTheme(R.style.Theme_Light);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), TaxiDatabase.class, "taxiBD").allowMainThreadQueries().build();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);

        db = FirebaseFirestore.getInstance();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.ic_baseline_menu_24);

        ImageView image = findViewById(R.id.menuopen);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.open();
            }
        });

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new emptyActivity()).commit();
        }

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottomHome:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new emptyActivity()).addToBackStack(null).commit();
                        return true;
                    case R.id.bottomSettings:
                        openActivity2();
                        return true;
                }
                return false;
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.insertFr:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insertFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.deleteFr:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new deleteFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.updateFr:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new updateFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.queryFr:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new QueryFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.homeFr:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new emptyActivity()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.insertReservation:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new reservationFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.queryReservation:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new QueryReservation()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return  true;
                    case R.id.updateReservation:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateReservation()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return  true;
                    case R.id.deleteReservation:
                        MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteReservation()).addToBackStack(null).commit();
                        drawerLayout.closeDrawers();
                        return  true;
                    case R.id.settingsFr:
                        openActivity2();
                        drawerLayout.closeDrawers();
                        return  true;
                }
                return false;
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this,settingsActivity.class);
        startActivity(intent);
        //finish();
    }
}
