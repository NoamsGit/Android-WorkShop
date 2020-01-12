package com.example.ddbproject.Data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ddbproject.Entities.Parcel;

import java.util.List;

@Dao
public interface ParcelDAO {
    @Insert
    void insert(Parcel... parcels);

    @Update
    void update(Parcel... parcels);

    @Query("SELECT * FROM Parcels")
    List<Parcel> getAllParcels();

    @Query("SELECT * FROM Parcels WHERE id = :id")
    Parcel getParcelById(String id);

    @Query("Delete From Parcels")
    void deleteAllNotes();
}
