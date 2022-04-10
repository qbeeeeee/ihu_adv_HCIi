package com.example.testingqbee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class deleteFragment extends Fragment implements View.OnClickListener {
    Button Bn_Sailor, Bn_Boat, Bn_Reserves;

    public deleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        Bn_Sailor = view.findViewById(R.id.deleteTaxiButton);
        Bn_Sailor.setOnClickListener(this);
        Bn_Boat = view.findViewById(R.id.deleteProekButton);
        Bn_Boat.setOnClickListener(this);
        Bn_Reserves = view.findViewById(R.id.deletePaekButton);
        Bn_Reserves.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.deleteTaxiButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteTaxiFragment()).addToBackStack(null).commit();
                break;
            case R.id.deleteProekButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteProekFragment()).addToBackStack(null).commit();
                break;
            case R.id.deletePaekButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeletePaekFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
