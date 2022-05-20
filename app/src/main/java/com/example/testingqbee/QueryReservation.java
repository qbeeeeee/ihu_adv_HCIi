package com.example.testingqbee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class QueryReservation extends Fragment {
    Spinner spinner;
    TextView querytextresult;
    ArrayAdapter<CharSequence> adapter;
    Button bnqueryrun;
    int pos;

    public QueryReservation(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_query_reservation, container, false);
        querytextresult = view.findViewById(R.id.txtqueryresultres);
        CollectionReference collectionReference = MainActivity.db.collection("CustomerReservation");
        final String[] queryArray = getResources().getStringArray(R.array.firebase_queries);
        spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.firebase_queries, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bnqueryrun = view.findViewById(R.id.queryrun);
        bnqueryrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] result = {""};

                switch (pos) {
                    case 1:
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
                        break;
                    case 2:
                        collectionReference.whereEqualTo("hotelName","Kapsis").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots) {
                                    CustomerReservation res = documentSnapshot.toObject(CustomerReservation.class);
                                    String customerName = res.getCustomerName();
                                    Integer rID = res.getrID();
                                    String hotelName = res.getHotelName();
                                    Integer travelPackageID = res.getTravelPackageID();
                                    result[0] += "rID: " +rID+ "\ncustomer name: " + customerName + "\nhotel name: " + hotelName+ "\ntravel package id: " +travelPackageID + "\n\n";
                                }
                                querytextresult.setText(result[0]);
                            }
                        }).addOnFailureListener(e -> {
                            Toast.makeText(getActivity(), "database is empty", Toast.LENGTH_LONG).show();
                        });
                        break;
                    case 3:
                        collectionReference.whereLessThanOrEqualTo("travelPackageID", 5).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots) {
                                    CustomerReservation res = documentSnapshot.toObject(CustomerReservation.class);
                                    String customerName = res.getCustomerName();
                                    Integer rID = res.getrID();
                                    String hotelName = res.getHotelName();
                                    Integer travelPackageID = res.getTravelPackageID();
                                    result[0] += "rID: " +rID+ "\ncustomer name: " + customerName + "\nhotel name: " + hotelName+ "\ntravel package id: " +travelPackageID + "\n\n";
                                }
                                querytextresult.setText(result[0]);
                            }
                        }).addOnFailureListener(e -> {
                            Toast.makeText(getActivity(), "database is empty", Toast.LENGTH_LONG).show();
                        });
                        break;
                    case 4:
                        collectionReference.whereGreaterThan("rID", 2).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots) {
                                    CustomerReservation res = documentSnapshot.toObject(CustomerReservation.class);
                                    String customerName = res.getCustomerName();
                                    Integer rID = res.getrID();
                                    String hotelName = res.getHotelName();
                                    Integer travelPackageID = res.getTravelPackageID();
                                    result[0] += "rID: " +rID+ "\ncustomer name: " + customerName + "\nhotel name: " + hotelName+ "\ntravel package id: " +travelPackageID + "\n\n";
                                }
                                querytextresult.setText(result[0]);
                            }
                        }).addOnFailureListener(e -> {
                            Toast.makeText(getActivity(), "database is empty", Toast.LENGTH_LONG).show();
                        });
                        break;
                }

            }
        });

        return view;
    }
}
