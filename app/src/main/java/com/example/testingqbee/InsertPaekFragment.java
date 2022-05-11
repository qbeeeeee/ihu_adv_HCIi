package com.example.testingqbee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;


public class InsertPaekFragment extends Fragment {
    EditText editText1, editText2, editText3 , editText4 , editText5;
    Button ribn;
    public InsertPaekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_paek, container, false);
        editText1 = view.findViewById(R.id.PaekidPaketouEditText1);
        editText2 = view.findViewById(R.id.PaekidGrafeiouEditText2);
        editText3 = view.findViewById(R.id.PaekKwdikosEkdromisEditText3);
        editText4 = view.findViewById(R.id.PaekDateEditText4);
        editText5 = view.findViewById(R.id.PaekPriceEditText5);
        ribn = view.findViewById(R.id.insertPaekSubmitButton);
        ribn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_paketoid = 0;
                try {
                    Var_paketoid = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }int Var_grafeioid = 0;
                try {
                    Var_grafeioid = Integer.parseInt(editText2.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }int Var_ekdromiid = 0;
                try {
                    Var_ekdromiid = Integer.parseInt(editText3.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }int Var_price = 0;
                try {
                    Var_price = Integer.parseInt(editText5.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_date = editText4.getText().toString();
                if (editText1.getText().toString().trim().length() < 1 || editText2.getText().toString().trim().length() < 1
                        || editText3.getText().toString().trim().length() < 1 || editText4.getText().toString().trim().length() < 1 ||
                 editText5.getText().toString().trim().length() < 1) {
                    Toast.makeText(getActivity(), "Sumplirwste ola ta pedia.", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        Paek paek = new Paek();
                        paek.setIdpaketou(Var_paketoid);
                        paek.setIdgrafeiou(Var_grafeioid);
                        paek.setIdekdromis(Var_ekdromiid);
                        paek.setDate(Var_date);
                        paek.setPrice(Var_price);
                        MainActivity.myAppDatabase.myDao().insertPaek(paek);
                        Toast.makeText(getActivity(), "Record added.", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
            }
        });
        return view;
    }
}

