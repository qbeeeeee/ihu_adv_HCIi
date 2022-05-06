package com.example.testingqbee;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class emptyActivity extends Fragment implements View.OnClickListener {
    CardView cSettings;
    CardView cInsert;
    CardView cDelete;
    CardView cUpdate;
    public emptyActivity(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.welcome, container, false);
        cSettings = view.findViewById(R.id.cardSettings);
        cSettings.setOnClickListener(this);
        cInsert = view.findViewById(R.id.cardInsert);
        cInsert.setOnClickListener(this);
        cUpdate = view.findViewById(R.id.cardUpdate);
        cUpdate.setOnClickListener(this);
        cDelete = view.findViewById(R.id.cardDelete);
        cDelete.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cardSettings:
                openActivity2();
                break;
            case R.id.cardInsert:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insertFragment()).addToBackStack(null).commit();
                break;
            case R.id.cardDelete:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new deleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.cardUpdate:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new updateFragment()).addToBackStack(null).commit();
                break;
        }
    }
    public void openActivity2(){
        Intent intent = new Intent(getActivity(),settingsActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
