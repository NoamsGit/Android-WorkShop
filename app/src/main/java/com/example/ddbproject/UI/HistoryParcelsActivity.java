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
import android.widget.TextView;

import com.example.ddbproject.Entities.Parcel;
import com.example.ddbproject.R;

import java.util.List;

public class HistoryParcelsActivity extends AppCompatActivity {
    private static final String TAG = "AddParcelActivity";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Parcel> parcelList;
    private HistoryViewModel historyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_parcels);

        Log.d(TAG, "111111111aaa");

        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        Log.d(TAG, "2222222222aaa");
        historyViewModel.getParcelList().observe(this, new Observer<List<Parcel>>() {
            @Override
            public void onChanged(List<Parcel> parcels) {
                parcelList.clear();
                parcelList = parcels;
            }
        });

        Log.d(TAG, "333333333aaa");
      /*  recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);*/


    }


 /*   public class ParcelsRecyclerViewAdapter extends RecyclerView.Adapter<ParcelsRecyclerViewAdapter.ParcelViewHolder>{

        @NonNull
        @Override
        public ParcelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getBaseContext()).inflate(R.layout.recyclerview_row, parent, false);
            return new ParcelViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ParcelViewHolder holder, int position) {
            holder.nameTextView.setText(parcelList.get(position).getName());
        }

        @Override
        public int getItemCount() {
            return parcelList.size();
        }
        ///
        private class ParcelViewHolder extends RecyclerView.ViewHolder {
            public TextView nameTextView;


            public ParcelViewHolder(@NonNull View itemView) {
                super(itemView);

                nameTextView = itemView.findViewById(R.id.nameTextView);


            }
        }
        ////

    }*/


}
