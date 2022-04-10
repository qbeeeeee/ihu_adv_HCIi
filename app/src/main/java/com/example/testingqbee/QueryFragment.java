package com.example.testingqbee;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QueryFragment extends Fragment {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView querytextView, querytextresult;
    Button bnqueryrun;
    int test;

    public QueryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query, container, false);
        final String[] queryArray = getResources().getStringArray(R.array.queries_description_array);
        querytextView = view.findViewById(R.id.txtquery);
        spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.queries_array, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                querytextView.setText(queryArray[position]);
                test = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        querytextresult = view.findViewById(R.id.txtqueryresult);
        bnqueryrun = view.findViewById(R.id.queryrun);
        bnqueryrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                querytextresult.setText("test" + test);
                String result = "";
                switch (test) {
                    case 1:
                        List<Taxi> taxi = MainActivity.myAppDatabase.myDao().getTaxi();
                        for (Taxi i : taxi) {
                            int code = i.getId();
                            String name = i.getName();
                            String adress = i.getAdress();
                            result = result + "\n Id: " + code + "\n Name: " + name + "\n Adress: " + adress;
                        }
                        querytextresult.setText(result);
                        break;
                    case 2:
                        List<Proek> proek = MainActivity.myAppDatabase.myDao().getProek();
                        for (Proek i : proek) {
                            int code = i.getId();
                            String poli = i.getPoli();
                            String xwra = i.getXwra();
                            int time = i.getDiarkeia();
                            String eidos = i.getEidos();
                            result = result + "\n Id: " + code + "\n Poli: " + poli + "\n Xwra: " + xwra + "\n Diarkeia: " + time + "\n Eidos: " + eidos;
                        }
                        querytextresult.setText(result);
                        break;
                    case 3:
                        List<Paek> paek = MainActivity.myAppDatabase.myDao().getPaek();
                        for (Paek i : paek) {
                            int idpaketou = i.getIdpaketou();
                            int idgrafeiou = i.getIdgrafeiou();
                            int idekdromis = i.getIdekdromis();
                            String date = i.getDate();
                            int price = i.getPrice();
                            result = result + "\n IdPaketou: " + idpaketou + "\n IdGrafeiou: " + idgrafeiou + "\n IdEkdromis: " + idekdromis +
                                    "\n Date: " + date + "\n Price: " + price;
                        }
                        querytextresult.setText(result);
                        break;
                    case 4:
                        List<ResultStringInt> resultStringInts = MainActivity.myAppDatabase.myDao().getQuery4();
                        for (ResultStringInt i : resultStringInts) {
                            String Taxi_name = i.getField1();
                            int Taxi_id = i.getField2();
                            result = result + "\n Taxidiotiko Name: " + Taxi_name + "\n Taxidiotiko ID: " + Taxi_id + "\n";
                        }
                        querytextresult.setText(result);
                        break;
                }
            }
        });
        return view;
    }
}
