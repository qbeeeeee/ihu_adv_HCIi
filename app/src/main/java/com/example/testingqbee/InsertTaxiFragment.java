package com.example.testingqbee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class InsertTaxiFragment extends Fragment {
    EditText editText1, editText2, editText3, editText4;
    Button sibn;
    public InsertTaxiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_taxi, container, false);
        editText1 = view.findViewById(R.id.TaxiEditText1);
        editText2 = view.findViewById(R.id.TaxiEditText2);
        editText3 = view.findViewById(R.id.TaxiEditText3);
        sibn = view.findViewById(R.id.insertTaxiSubmitButton);
        sibn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_taxiid = 0;
                try {
                    Var_taxiid = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_taxiname = editText2.getText().toString();
                String Var_taxiadress = editText3.getText().toString();

                if (editText1.getText().toString().trim().length() < 1 || editText2.getText().toString().trim().length() < 1
                        || editText3.getText().toString().trim().length() < 1 ) {
                    Toast.makeText(getActivity(), "Sumplirwste ola ta pedia.", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        Taxi taxi = new Taxi();
                        taxi.setId(Var_taxiid);
                        taxi.setName(Var_taxiname);
                        taxi.setAdress(Var_taxiadress);
                        MainActivity.myAppDatabase.myDao().insertTaxi(taxi);
                        Toast.makeText(getActivity(), "Record added.", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        });
        return view;
    }
}