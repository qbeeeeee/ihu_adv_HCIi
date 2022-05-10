package com.example.testingqbee;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class updateFragment extends Fragment implements View.OnClickListener {
    Button Bn_Taxi, Bn_Proek, Bn_Paek;

    public updateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        Bn_Taxi = view.findViewById(R.id.updateTaxiButton);
        Bn_Taxi.setOnClickListener(this);
        Bn_Proek = view.findViewById(R.id.updateProekButton);
        Bn_Proek.setOnClickListener(this);
        Bn_Paek = view.findViewById(R.id.updatePaekButton);
        Bn_Paek.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.updateTaxiButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateTaxiFragment()).addToBackStack(null).commit();
                break;
            case R.id.updateProekButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateProekFragment()).addToBackStack(null).commit();
                break;
            case R.id.updatePaekButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdatePaekFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
