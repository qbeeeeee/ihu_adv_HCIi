package com.example.testingqbee;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UpdateReservation extends Fragment implements AdapterView.OnItemSelectedListener {

    EditText idField, nameField, packageField;
    Spinner hotelField;
    Button updateBtn;

    public UpdateReservation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_update_reservation, container, false);

        idField = view.findViewById(R.id.UpreservationId);
        nameField = view.findViewById(R.id.Upuser);
        packageField = view.findViewById(R.id.Upids);
        updateBtn = view.findViewById(R.id.UpreservationBtn);
        hotelField = view.findViewById(R.id.Uphotels);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.hotels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hotelField.setAdapter(adapter);
        hotelField.setOnItemSelectedListener(this);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Var_rsvID = 0;
                try{
                    Var_rsvID = Integer.parseInt(idField.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse " + ex);
                }
                String Var_user = nameField.getText().toString();
                int Var_travel_pack_id = 0;
                try{
                    Var_travel_pack_id = Integer.parseInt(packageField.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse " + ex);
                }
                String Var_hotel = hotelField.getSelectedItem().toString();

                DocumentReference docRef = FirebaseFirestore.getInstance()
                        .collection("CustomerReservation")
                        .document(String.valueOf(Var_rsvID));

                Map<String, Object> map = new HashMap<>();
                map.put("customerName",String.valueOf(Var_user));
                map.put("hotelName", String.valueOf(Var_hotel));
                map.put("travelPackageID", Var_travel_pack_id);

                docRef.update(map)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(getActivity(), "Reservation updated", Toast.LENGTH_LONG).show();


                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getActivity(), "update operation failed", Toast.LENGTH_LONG).show();

                            }
                        });
            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
