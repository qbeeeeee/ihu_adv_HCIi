package com.example.testingqbee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertProekFragment extends Fragment {
    EditText editText1, editText2, editText3 , editText4, editText5;
    Button bibn;
    public InsertProekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_proek, container, false);
        editText1 = view.findViewById(R.id.ProekEditText1);
        editText2 = view.findViewById(R.id.ProekEditText2);
        editText4 = view.findViewById(R.id.ProekEditText4);
        editText5 = view.findViewById(R.id.ProekEditText5);
        bibn = view.findViewById(R.id.insertProekSubmitButton);
        bibn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_proekid = 0;
                try {
                    Var_proekid = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_proekpoli = editText2.getText().toString();
                String Var_proekxwra = editText3.getText().toString();
                int Var_diarkeia = 0;
                try {
                    Var_diarkeia = Integer.parseInt(editText4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_eidosek = editText5.getText().toString();
                if (editText1.getText().toString().trim().length() < 1 || editText2.getText().toString().trim().length() < 1
                        || editText3.getText().toString().trim().length() < 1 || editText4.getText().toString().trim().length() < 1 ||
                        editText5.getText().toString().trim().length() < 1) {
                    Toast.makeText(getActivity(), "Sumplirwste ola ta pedia.", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        Proek proek = new Proek();
                        proek.setId(Var_proekid);
                        proek.setPoli(Var_proekpoli);
                        proek.setXwra(Var_proekxwra);
                        proek.setDiarkeia(Var_diarkeia);
                        proek.setEidos(Var_eidosek);
                        MainActivity.myAppDatabase.myDao().insertProek(proek);
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
