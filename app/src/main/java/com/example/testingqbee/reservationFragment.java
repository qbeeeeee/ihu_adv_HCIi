package com.example.testingqbee;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;


public class reservationFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner hotelspinner;
    EditText user, id, resID;
    Button resBtn;




    public reservationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
    hotelspinner = view.findViewById(R.id.hotels);
    user = view.findViewById(R.id.user);
    resID = view.findViewById(R.id.reservationId);
    id = view.findViewById(R.id.ids);
    resBtn = view.findViewById(R.id.reservationBtn);


    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.hotels, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    hotelspinner.setAdapter(adapter);
    hotelspinner.setOnItemSelectedListener(this);

    resBtn.setOnClickListener(new View.OnClickListener() {
        @Override

        public void onClick(View view) {

            int Var_rsvID = 0;
            try{
                Var_rsvID = Integer.parseInt(resID.getText().toString());
            }catch (NumberFormatException ex){
                System.out.println("Could not parse " + ex);
            }
            String Var_user = user.getText().toString();
            int Var_travel_pack_id = 0;
            try{
                Var_travel_pack_id = Integer.parseInt(id.getText().toString());
            }catch (NumberFormatException ex){
                System.out.println("Could not parse " + ex);
            }

            String Var_hotel = hotelspinner.getSelectedItem().toString();

            boolean idExists = false;

            List<Paek> paek = MainActivity.myAppDatabase.myDao().getPaek();
            for (Paek i : paek) {
                int id = i.getIdpaketou();
                 if (id == Var_travel_pack_id) {
                    idExists = true;
                 }
            }

            if(idExists){
                try {
                    CustomerReservation res = new CustomerReservation();
                    res.setrID(Var_rsvID);
                    res.setCustomerName(Var_user);
                    res.setHotelName(Var_hotel);
                    res.setTravelPackageID(Var_travel_pack_id);


                    int finalVar_rsvID = Var_rsvID;
                    MainActivity.db.collection("CustomerReservation").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            int exists = 0;
                            String result = "";
                            for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots) {
                                CustomerReservation res = documentSnapshot.toObject(CustomerReservation.class);
                                int rID = res.getrID();

                                if(rID == finalVar_rsvID){
                                    exists = 1;
                                }
                            }
                            if(exists == 0){
                            MainActivity.db.
                                    collection("CustomerReservation").
                                    document(""+finalVar_rsvID).
                                    set(res).
                                    addOnCompleteListener(task -> {
                                        Toast.makeText(getActivity(), "Reservation added", Toast.LENGTH_LONG).show();


                                    }).
                                    addOnFailureListener(e -> {
                                        Toast.makeText(getActivity(), "add operation failed", Toast.LENGTH_LONG).show();
                                    });
                            }else{
                                Toast.makeText(getActivity(), "Reservation with ID " + finalVar_rsvID+" already exists", Toast.LENGTH_LONG).show();

                            }
                        }
                    });






                }catch(Exception e){
                    String message = e.getMessage();
                    Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                }
            }else{
                String error = "Travel Package ID does not exist";
                Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
            }
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
