package com.example.ddbproject.UI;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ddbproject.Data.ParcelRepository;
import com.example.ddbproject.Entities.Parcel;
import com.example.ddbproject.Entities.ParcelChange;

public class ParcelViewModel extends AndroidViewModel {
    private ParcelRepository parcelRepository;
    private MutableLiveData<ParcelChange> parcelChange;

// -------- constructor --------
    public ParcelViewModel(Application application) {
        super(application);
        parcelRepository = ParcelRepository.getInstance(application);
        parcelChange = parcelRepository.getParcelChange();
    }



// -------- expose API for upper layers --------
    public void addParcel(Parcel parcel){
        parcelRepository.addParcel(parcel);
    }

    public MutableLiveData<ParcelChange> getParcelChange(){
        return parcelChange;
    }
}
