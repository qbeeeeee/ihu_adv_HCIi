package com.example.testingqbee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class menuFragment extends Fragment implements View.OnClickListener {
    Button Bn_insert, Bn_delete, Bn_update, Bn_Query;
    public menuFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        Bn_insert = view.findViewById(R.id.insertButton);
        Bn_insert.setOnClickListener(this);
        Bn_delete = view.findViewById(R.id.deleteButton);
        Bn_delete.setOnClickListener(this);
        Bn_update = view.findViewById(R.id.updateButton);
        Bn_update.setOnClickListener(this);
        Bn_Query = view.findViewById(R.id.queryButton);
        Bn_Query.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.insertButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new insertFragment()).addToBackStack(null).commit();
                break;
            case R.id.deleteButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new deleteFragment()).addToBackStack(null).commit();
                break;
            case R.id.updateButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new updateFragment()).addToBackStack(null).commit();
                break;
            case R.id.queryButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new QueryFragment()).addToBackStack(null).commit();
                break;
        }
    }
}

