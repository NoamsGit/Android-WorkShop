package com.example.ddbproject.UI;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ddbproject.Data.ParcelRepository;
import com.example.ddbproject.Entities.Parcel;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {
    private static final String TAG = "AddParcelActivity";

    private ParcelRepository parcelRepository;
    private MutableLiveData<List<Parcel>> parcelList;

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        Log.d(TAG, "--- HistoryViewModel constructor 01 ---");
        parcelRepository = ParcelRepository.getInstance(application);
        Log.d(TAG, "--- HistoryViewModel constructor 02 ---");
        parcelList = parcelRepository.getParcelList();
        Log.d(TAG, "--- HistoryViewModel constructor 03 ---");
    }

    public  MutableLiveData<List<Parcel>> getParcelList() {
        return parcelList;
    }
}
