package com.example.ddbproject.Data;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.ddbproject.Entities.Parcel;
import com.example.ddbproject.Entities.ParcelChange;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ParcelDataSource {
    private static ParcelDataSource instance = null;
    private static DatabaseReference parcelsRef;
    private static MutableLiveData<ParcelChange> parcelChange;



//--------- constractor ---------
    private ParcelDataSource() {
        parcelChange = new MutableLiveData<ParcelChange>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        parcelsRef = database.getReference("Parcel");
    }

//--------- singleton implementation ---------
    public static ParcelDataSource getInstance() {
        if (instance == null) {
            instance = new ParcelDataSource();
        }
        return instance;
    }

// -------- expose API for upper layers --------
    public interface NotifyDataChange<T> {
      void OnDataChanged(T obj);
      void onFailure(Exception exception);
    }

    public MutableLiveData<ParcelChange> getParcelChange() {
        return parcelChange;
    }

    public static void addParcel(Parcel parcel) {
        addParcelToFirebase(parcel);
    }

// -------- functions for iner use --------
    private static void addParcelToFirebase(Parcel parcel) {
        //String key = Parcel.getId().toString();
        //int a;
        String key = parcelsRef.push().getKey();
        parcel.setId(key);
        parcelsRef.child(key).setValue(parcel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                parcelAddedSuccessfully();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                parcelAddedFailure();
            }
        });

    }

    private static void parcelAddedSuccessfully() {
        ParcelChange parcelChangeTemp = new ParcelChange();
        parcelChangeTemp.setSuccess(true);
        parcelChange.setValue(parcelChangeTemp);
    }

    private static void parcelAddedFailure() {
        ParcelChange parcelChangeTemp = new ParcelChange();
        parcelChangeTemp.setFailure(true);
        parcelChange.setValue(parcelChangeTemp);
    }






}
