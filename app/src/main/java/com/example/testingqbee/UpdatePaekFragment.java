package com.example.testingqbee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UpdatePaekFragment extends Fragment {
    EditText editText1, editText2, editText3 , editText4, editText5;
    Button ribn;
    public UpdatePaekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_paek, container, false);
        editText1 = view.findViewById(R.id.updatePaekpaketoEditText1);
        editText2 = view.findViewById(R.id.updatePaekgrafeioEditText2);
        editText3 = view.findViewById(R.id.updatePaekpaketoEditText3);
        editText4 = view.findViewById(R.id.updatePaekDateEditText4);
        editText5 = view.findViewById(R.id.updatePaekPriceEditText5);
        ribn = view.findViewById(R.id.updatePaekSubmitButton);
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
                boolean idExists = false;
                boolean idExists2 = false;
                boolean idExists3 = false;

                List<Proek> proek2 = MainActivity.myAppDatabase.myDao().getProek();
                for (Proek i : proek2) {
                    int id = i.getId();
                    if (id == Var_ekdromiid) {
                        idExists2 = true;
                    }
                }

                List<Taxi> taxi2 = MainActivity.myAppDatabase.myDao().getTaxi();
                for (Taxi i : taxi2) {
                    int id = i.getId();
                    if (id == Var_grafeioid) {
                        idExists3 = true;
                    }
                }

                List<Paek> paek2 = MainActivity.myAppDatabase.myDao().getPaek();
                for (Paek i : paek2) {
                    int id = i.getIdpaketou();
                    if (id == Var_paketoid) {
                        idExists = true;
                    }
                }
                if (editText1.getText().toString().trim().length() < 1 || editText2.getText().toString().trim().length() < 1
                        || editText3.getText().toString().trim().length() < 1 || editText4.getText().toString().trim().length() < 1 ||
                        editText5.getText().toString().trim().length() < 1) {
                    Toast.makeText(getActivity(), "Sumplirwste ola ta pedia.", Toast.LENGTH_LONG).show();
                }else if(!idExists) {
                    Toast.makeText(getActivity(), "Paketo ID does not exist.", Toast.LENGTH_LONG).show();
                }else if(!idExists2) {
                    Toast.makeText(getActivity(), "Paketo Ekdromis ID does not exist.", Toast.LENGTH_LONG).show();
                }else if(!idExists3) {
                    Toast.makeText(getActivity(), "ID Taxidiotikou does not exist.", Toast.LENGTH_LONG).show();
                }else{
                    try {
                        Paek paek = new Paek();
                        paek.setIdpaketou(Var_paketoid);
                        paek.setIdgrafeiou(Var_grafeioid);
                        paek.setIdekdromis(Var_ekdromiid);
                        paek.setDate(Var_date);
                        paek.setPrice(Var_price);
                        MainActivity.myAppDatabase.myDao().updatePaek(paek);
                        Toast.makeText(getActivity(), "Paketo ekdromis updated.", Toast.LENGTH_LONG).show();
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