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

public class DeletePaekFragment extends Fragment {
    EditText editText1, editText2, editText3;
    Button ribn;
    public DeletePaekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_paek, container, false);
        editText1 = view.findViewById(R.id.EditTextPaekPak);
        editText2 = view.findViewById(R.id.EditTextPaekGraf);
        editText3 = view.findViewById(R.id.EditTextPaekEkdromi);
        ribn = view.findViewById(R.id.delpaek);
        ribn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_idpak = 0;
                try {
                    Var_idpak = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }int Var_idgrafeiou = 0;
                try {
                    Var_idgrafeiou = Integer.parseInt(editText2.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }int Var_idekdromis = 0;
                try {
                    Var_idekdromis = Integer.parseInt(editText2.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                boolean idExists = false;

                List<Paek> paek2 = MainActivity.myAppDatabase.myDao().getPaek();
                for (Paek i : paek2) {
                    int id = i.getIdpaketou();
                    if (id == Var_idpak) {
                        idExists = true;
                    }
                }
                if (editText1.getText().toString().trim().length() < 1 || editText2.getText().toString().trim().length() < 1
                        || editText3.getText().toString().trim().length() < 1 ) {
                    Toast.makeText(getActivity(), "Sumplirwste ola ta pedia.", Toast.LENGTH_LONG).show();
                } else if(!idExists) {
                    Toast.makeText(getActivity(), "ID paketou does not exist.", Toast.LENGTH_LONG).show();
                }else{
                    try {
                        Paek paek = new Paek();
                        paek.setIdpaketou(Var_idpak);
                        paek.setIdgrafeiou(Var_idgrafeiou);
                        paek.setIdekdromis(Var_idekdromis);
                        MainActivity.myAppDatabase.myDao().deletePaek(paek);
                        Toast.makeText(getActivity(), "Paek deleted.", Toast.LENGTH_LONG).show();
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

