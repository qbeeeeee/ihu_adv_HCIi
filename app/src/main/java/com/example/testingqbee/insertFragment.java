package com.example.testingqbee;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class insertFragment extends Fragment implements View.OnClickListener {
    Button Bn_ins_Taxi, Bn_ins_Proek, Bn_ins_Paek;

    public insertFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert, container, false);
        Bn_ins_Taxi = view.findViewById(R.id.insertTaxiButton);
        Bn_ins_Taxi.setOnClickListener(this);
        Bn_ins_Proek = view.findViewById(R.id.insertProekButton);
        Bn_ins_Proek.setOnClickListener(this);
        Bn_ins_Paek = view.findViewById(R.id.insertPaekButton);
        Bn_ins_Paek.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insertTaxiButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertTaxiFragment()).addToBackStack(null).commit();
                break;
            case R.id.insertProekButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertProekFragment()).addToBackStack(null).commit();
                break;
            case R.id.insertPaekButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertPaekFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
