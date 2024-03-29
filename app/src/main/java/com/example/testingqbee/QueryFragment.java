package com.example.testingqbee;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.lang.annotation.Native;
import java.lang.reflect.Array;
import java.util.List;

public class QueryFragment extends Fragment {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView querytextView, querytextresult;
    Button bnqueryrun, showMap;
    double[] markCoords;
    String[] markNames;
    int test;

    OnbundleSendListener bundleSendListener;
    public interface OnbundleSendListener{
        public void onBundleSendListener(Bundle b);
    }

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
        showMap = view.findViewById(R.id.viewOnMaps);
        showMap.setEnabled(false);
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

        showMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int orientation = getResources().getConfiguration().orientation;
                Bundle b = new Bundle();
                b.putDoubleArray("coords", markCoords);
                b.putStringArray("names", markNames);
                if(orientation==1) {
                    Intent intent = new Intent(getActivity(), MapsActivity.class);
                    intent.putExtras(b);
                    startActivityForResult(intent, 100);
                }
                else {
                    bundleSendListener.onBundleSendListener(b);
                }
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
                            result = result + "\n Id: " + code + "\n Name: " + name + "\n Adress: " + adress + "\n";
                        }
                        querytextresult.setText(result);
                        break;
                    case 2:
                        showMap.setEnabled(true);
                        int j=0;
                        List<Proek> proek = MainActivity.myAppDatabase.myDao().getProek();
                        markCoords = new double[proek.size()*2];
                        markNames = new String[proek.size()*2];
                        for (Proek i : proek) {
                            markCoords[j] = i.getLat();
                            markNames[j++] = i.getPoli();
                            markCoords[j] = i.getLon();
                            markNames[j++] = i.getXwra();
                            int code = i.getId();
                            String poli = i.getPoli();
                            String xwra = i.getXwra();
                            int time = i.getDiarkeia();
                            String eidos = i.getEidos();
                            result = result + "\n Id: " + code + "\n Poli: " + poli + "\n Xwra: " + xwra + "\n Diarkeia: " + time + "\n Eidos: " + eidos + "\n";
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
                                    "\n Date: " + date + "\n Price: " + price + "\n";
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
                    case 5:
                        List<ResultStringInt> resultStringInts2 = MainActivity.myAppDatabase.myDao().getQuery5();
                        for (ResultStringInt i : resultStringInts2) {
                            String Proek_poli = i.getField1();
                            int Proek_id = i.getField2();
                            result = result + "\n Country: " + Proek_poli + "\n Proek ID =" + Proek_id + "\n";
                        }
                        querytextresult.setText(result);
                        break;
                    case 6:
                        List<ResultStringInt> resultStringInts3 = MainActivity.myAppDatabase.myDao().getQuery6();
                        for (ResultStringInt i : resultStringInts3) {
                            String Paek_date = i.getField1();
                            int Paek_id = i.getField2();
                            result = result + "\n Paek date: " + Paek_date + "\n Paketo ID: " + Paek_id + "\n";
                        }
                        querytextresult.setText(result);
                        break;
                }
            }
        });
        return view;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            bundleSendListener = (OnbundleSendListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException();
        }
    }
}
