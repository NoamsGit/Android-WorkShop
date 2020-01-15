package com.example.ddbproject.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ddbproject.Entities.Parcel;
import com.example.ddbproject.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryParcelsActivity extends AppCompatActivity {
    private static final String TAG = "AddParcelActivity";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Parcel> parcelList;
    private List<String> parcelStringList;
    private HistoryViewModel historyViewModel;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_parcels);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        parcelList = new ArrayList<Parcel>();

        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        historyViewModel.getParcelList().observe(this, new Observer<List<Parcel>>() {
            @Override
            public void onChanged(List<Parcel> parcels) {
                parcelList.clear();
                Log.d(TAG, "-----------------------------");
                Log.d(TAG, "Was cleared");
                Log.d(TAG, "-----------------------------");
                for (int i = 0; i < parcels.size(); i++) {
                    parcelList.add(parcels.get(i));
                }
                Log.d(TAG, "-----------------------------");


            }
        });

        final ParcelAdapter parcelAdapter = new ParcelAdapter(parcelList);

        recyclerView.setAdapter(parcelAdapter);
        Log.d(TAG, "666666666aaa");

    }
    @Override
    protected void onDestroy() {

       // historyViewModel.stopNotifyToParceltList();
        super.onDestroy();
    }




}
