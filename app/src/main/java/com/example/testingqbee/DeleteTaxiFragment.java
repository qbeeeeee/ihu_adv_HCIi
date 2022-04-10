package com.example.testingqbee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class DeleteTaxiFragment extends Fragment {
    EditText editText;
    Button button;
    public DeleteTaxiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_taxi, container, false);
        editText = view.findViewById(R.id.editTexttaxidel);
        button = view.findViewById(R.id.deltaxi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_id = 0;
                try {
                    Var_id = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                Taxi taxi = new Taxi();
                taxi.setId(Var_id);
                MainActivity.myAppDatabase.myDao().deleteTaxi(taxi);
                Toast.makeText(getActivity(),"Taxi deleted ",Toast.LENGTH_LONG).show();
                editText.setText("");
            }
        });
        return view;
    }
}
