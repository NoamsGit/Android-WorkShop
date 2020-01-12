package com.example.ddbproject.Data;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.example.ddbproject.Entities.Parcel;
import com.example.ddbproject.Entities.ParcelChange;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ParcelRepository {
    private static final String TAG = "AddParcelActivity";
    private static  ParcelRepository instance = null;
    private MutableLiveData<ParcelChange> parcelChange;
    private ParcelDataSource parcelDataSourse;
    private HistoryDataSource historyDataSource ;
    private ParcelDAO parcelDAO;
    private List<Parcel> dummyList;
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
        Log.d(TAG, "--- ParcelRepository constructor 01 ---");
        dummyList = new ArrayList<Parcel>();
        dummyList.add(new Parcel("12", "aa", "bb"));
        parcelDataSourse = ParcelDataSource.getInstance();
        parcelChange = new MutableLiveData<ParcelChange>();
        parcelChange = parcelDataSourse.getParcelChange();
        Log.d(TAG, "--- ParcelRepository constructor 02 ---");
        historyDataSource = HistoryDataSource.getInstance(application.getApplicationContext());
        parcelDAO = historyDataSource.parcelDAO();
        parcelList = new MutableLiveData<List<Parcel>>();
        parcelDAO.deleteAllNotes();
        Log.d(TAG, "--- ParcelRepository constructor 03 ---");
        ParcelDataSource.notifyToParcelList(new ParcelDataSource.NotifyDataChange<Parcel>(){
            @Override
            public void OnDataChanged(Parcel obj) {
                Log.d(TAG, "--- ParcelRepository OnDataChanged 01 ---");
                Parcel parcel = (Parcel) obj;
                Log.d(TAG, "--- ParcelRepository OnDataChanged 02 ---");

                Parcel ExistsInRoom = parcelDAO.getParcelById(parcel.getId());
                Log.d(TAG, "--- ParcelRepository OnDataChanged 03 ---");

                if(ExistsInRoom == null){
                    Log.d(TAG, "--- ParcelRepository OnDataChanged insert 01 ---");

                    parcelDAO.insert(parcel);
                    Log.d(TAG, "--- ParcelRepository OnDataChanged insert 02 ---");
                }
                else {
                    Log.d(TAG, "--- ParcelRepository OnDataChanged update 01 ---");

                    parcelDAO.update(parcel);
                    Log.d(TAG, "--- ParcelRepository OnDataChanged update 02 ---");

                }
                Log.d(TAG, "--- ParcelRepository OnDataChanged  04 ---");
                parcelDAO.getAllParcels();
                Log.d(TAG, "--- ParcelRepository OnDataChanged  05 ---");

                parcelList.postValue(parcelDAO.getAllParcels());
                //parcelList.postValue(dummyList);
                //parcelList.setValue(dummyList);

                Log.d(TAG, "--- ParcelRepository OnDataChanged  06 ---");

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
