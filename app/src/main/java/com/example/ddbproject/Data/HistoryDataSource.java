package com.example.ddbproject.Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ddbproject.Entities.Parcel;

@Database(entities = {Parcel.class}, version = 1,exportSchema = false)
public abstract class HistoryDataSource extends RoomDatabase {
    private static HistoryDataSource instance = null;
    public abstract ParcelDAO parcelDAO();

    public static synchronized HistoryDataSource getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), HistoryDataSource.class,
                    "parcel_database").allowMainThreadQueries().build();
        }
        return instance;
    }



}
