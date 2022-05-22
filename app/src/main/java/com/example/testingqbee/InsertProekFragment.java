package com.example.testingqbee;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;

public class InsertProekFragment extends Fragment {
    EditText editText1, editText2, editText3 , editText4, editText5;
    Button bibn;
    double lat = 0;
    double lon = 0;
    String Var_proekpoli = "";
    String Var_proekxwra = "";

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

        Places.initialize(getActivity().getApplicationContext(), "AIzaSyBARqbqqh_0d_ptuMdKVTRr9WMhHb1mxlE");
        editText2.setFocusable(false);
        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME,
                        Place.Field.LAT_LNG, Place.Field.ADDRESS_COMPONENTS);
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                        .build(getActivity());
                startActivityForResult(intent, 100);
            }
        });

        bibn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_proekid = 0;
                try {
                    Var_proekid = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                int Var_diarkeia = 0;
                try {
                    Var_diarkeia = Integer.parseInt(editText4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_eidosek = editText5.getText().toString();
                if (editText1.getText().toString().trim().length() < 1 || editText2.getText().toString().trim().length() < 1
                        || editText4.getText().toString().trim().length() < 1 ||
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
                        proek.setLat(lat);
                        proek.setLon(lon);
                        MainActivity.myAppDatabase.myDao().insertProek(proek);
                        Toast.makeText(getActivity(), "Record added.", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                }
                editText1.setText("");
                editText2.setText("");
                editText4.setText("");
                editText5.setText("");
            }
        });

        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==getActivity().RESULT_OK) {
            Place place = Autocomplete.getPlaceFromIntent(data);
            Var_proekxwra = place.getName();
            Var_proekpoli = place.getAddressComponents().asList().get(2).getName();
            editText2.setText(String.format("%s, %s", Var_proekpoli, Var_proekxwra));
            lat = place.getLatLng().latitude;
            lon = place.getLatLng().longitude;
        }
        else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
            Status status = Autocomplete.getStatusFromIntent(data);
            Toast.makeText(getActivity().getApplicationContext(), status.getStatusMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
