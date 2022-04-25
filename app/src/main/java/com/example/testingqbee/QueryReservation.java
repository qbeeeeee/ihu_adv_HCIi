package com.example.testingqbee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class QueryReservation extends Fragment {
    TextView querytextresult;


    public QueryReservation(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_query_reservation, container, false);
        querytextresult = view.findViewById(R.id.txtqueryresultres);
        CollectionReference collectionReference = MainActivity.db.collection("CustomerReservation");

        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String result = "";
                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots) {
                    CustomerReservation res = documentSnapshot.toObject(CustomerReservation.class);
                    String customerName = res.getCustomerName();
                    Integer rID = res.getrID();
                    String hotelName = res.getHotelName();
                    Integer travelPackageID = res.getTravelPackageID();
                    result += "rID: " +rID+ "\ncustomer name: " + customerName + "\nhotel name: " + hotelName+ "\ntravel package id: " +travelPackageID + "\n\n";
                }
                querytextresult.setText(result);
            }
        }).addOnFailureListener(e -> {
            Toast.makeText(getActivity(), "database is empty", Toast.LENGTH_LONG).show();
        });
        return view;
    }
}
