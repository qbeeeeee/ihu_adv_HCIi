package com.example.testingqbee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateProekFragment extends Fragment {
    EditText editText1, editText2, editText3 , editText4, editText5;
    Button bibn;
    public UpdateProekFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_proek, container, false);
        editText1 = view.findViewById(R.id.UpdateProekEditText1);
        editText2 = view.findViewById(R.id.UpdateProekEditText2);
        editText3 = view.findViewById(R.id.UpdateProekEditText3);
        editText4 = view.findViewById(R.id.UpdateProekEditText4);
        editText5 = view.findViewById(R.id.UpdateProekEditText5);
        bibn = view.findViewById(R.id.updateProekSubmitButton);
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
                int Var_proekdiarkeia = 0;
                try {
                    Var_proekdiarkeia = Integer.parseInt(editText4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_proekeidos = editText5.getText().toString();
                try {
                    Proek proek = new Proek();
                    proek.setId(Var_proekid);
                    proek.setPoli(Var_proekpoli);
                    proek.setXwra(Var_proekxwra);
                    proek.setDiarkeia(Var_proekdiarkeia);
                    proek.setEidos(Var_proekeidos);
                    MainActivity.myAppDatabase.myDao().updateProek(proek);
                    Toast.makeText(getActivity(),"Protinomeni ekdromi updated.",Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
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
