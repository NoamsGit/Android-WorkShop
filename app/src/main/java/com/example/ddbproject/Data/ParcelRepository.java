package com.example.ddbproject.Data;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.ddbproject.Entities.Parcel;
import com.example.ddbproject.Entities.ParcelChange;

import java.util.List;

public class ParcelRepository {
    private static final String TAG = "AddParcelActivity";
    private static  ParcelRepository instance = null;
    private MutableLiveData<ParcelChange> parcelChange;
    private ParcelDataSource parcelDataSourse;
    private HistoryDataSource historyDataSource ;
    private ParcelDAO parcelDAO;
    private MutableLiveData<List<Parcel>> parcelList;


//--------- singleton implementation ---------
    public static ParcelRepository getInstance(Application application){
        if(instance == null){
            instance = new ParcelRepository(application);
        }
        return instance;
    }

//--------- constractor  ---------
    private ParcelRepository(Application application) {
        parcelDataSourse = ParcelDataSource.getInstance();
        parcelChange = new MutableLiveData<ParcelChange>();
        parcelChange = parcelDataSourse.getParcelChange();
        historyDataSource = HistoryDataSource.getInstance(application.getApplicationContext());
        parcelDAO = historyDataSource.parcelDAO();
        parcelList = new MutableLiveData<List<Parcel>>();

        ParcelDataSource.notifyToParcelList(new ParcelDataSource.NotifyDataChange<Parcel>(){
            @Override
            public void OnDataChanged(Parcel obj) {
                Parcel parcel = (Parcel) obj;
                Parcel ExistsInRoom = parcelDAO.getParcelById(parcel.getId());
                if(ExistsInRoom == null){
                    parcelDAO.insert(parcel);
                }
                else {
                    parcelDAO.update(parcel);
                }
                parcelList.setValue(parcelDAO.getAllParcels());
            }

            @Override
            public void onFailure(Exception exception) {
                ///////
            }
        });

    }

// -------- expose API for upper layers --------
    public  MutableLiveData<ParcelChange> getParcelChange() {
        return parcelChange;
    }

    public  MutableLiveData<List<Parcel>> getParcelList() {
        return parcelList;
    }

    public  void addParcel(final Parcel parcel) {
        parcelDataSourse.addParcel(parcel);
    }





}
