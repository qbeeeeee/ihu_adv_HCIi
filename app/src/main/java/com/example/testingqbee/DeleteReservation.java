package com.example.testingqbee;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DeleteReservation extends Fragment {

    EditText deleteRes;
    Button deleteBtn;

    public DeleteReservation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_delete_reservation, container,false);
        deleteRes = view.findViewById(R.id.delReservationInput);
        deleteBtn = view.findViewById(R.id.delReservationBtn);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Var_rsvID = -1;
                try{
                    Var_rsvID = Integer.parseInt(deleteRes.getText().toString());
                }catch (NumberFormatException ex){
                    System.out.println("Could not parse " + ex);
                }

                if(deleteRes.getText().toString().trim().length() < 1){
                    Toast.makeText(getActivity(), "Error: Please Insert ID", Toast.LENGTH_LONG).show();
                }else{
                    Task<Void> docRef = FirebaseFirestore.getInstance()
                            .collection("CustomerReservation")
                            .document(String.valueOf(Var_rsvID))
                            .delete()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getActivity(), "Reservation Deleted ", Toast.LENGTH_LONG).show();
                                    Toast.makeText(getActivity(), "Reservation Deleted ", Toast.LENGTH_LONG).show();
                                    deleteRes.setText("");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(), "Delete operation failed", Toast.LENGTH_LONG).show();
                                }
                            });
                }
            }
        });


        return view;
    }
}
