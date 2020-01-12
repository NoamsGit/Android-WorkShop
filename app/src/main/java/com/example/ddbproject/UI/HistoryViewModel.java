package com.example.ddbproject.UI;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ddbproject.Data.ParcelRepository;
import com.example.ddbproject.Entities.Parcel;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {
    private ParcelRepository parcelRepository;
    private MutableLiveData<List<Parcel>> parcelList;

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        parcelRepository = ParcelRepository.getInstance(application);
        parcelList = parcelRepository.getParcelList();
    }

    public  MutableLiveData<List<Parcel>> getParcelList() {
        return parcelList;
    }
}
