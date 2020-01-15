package com.example.ddbproject.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ddbproject.Entities.Parcel;
import com.example.ddbproject.R;

import java.util.List;

public class ParcelAdapter extends RecyclerView.Adapter<ParcelAdapter.ParcelViewHolder>  {
    private List<Parcel> parcels;
    //private MyCountryListener listener;

    public ParcelAdapter(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    public class ParcelViewHolder extends RecyclerView.ViewHolder {

        TextView nameTv;
        TextView populationTv;
        ImageView flagIv;
        CheckBox goodCb;

        public ParcelViewHolder(View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.country_name);
            populationTv = itemView.findViewById(R.id.country_population);
            flagIv = itemView.findViewById(R.id.country_flag);
            goodCb = itemView.findViewById(R.id.country_checkbox);

        }



    }
    @Override
    public ParcelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        ParcelViewHolder countryViewHolder = new ParcelViewHolder(view);
        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(ParcelViewHolder holder, int position) {
        Parcel parcel = parcels.get(position);
        holder.nameTv.setText(parcel.getName());
        holder.populationTv.setText(parcel.getAddress());
        //holder.flagIv.setImageResource(country.getFlagResId());
        //holder.goodCb.setChecked(parcel.isGood());
    }
    @Override
    public int getItemCount() {
        return parcels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


}
