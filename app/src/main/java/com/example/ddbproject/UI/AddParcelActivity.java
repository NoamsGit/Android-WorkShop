package com.example.ddbproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ddbproject.Entities.Parcel;
import com.example.ddbproject.Entities.ParcelChange;
import com.example.ddbproject.R;

public class AddParcelActivity extends AppCompatActivity {
    private static final String TAG = "AddParcelActivity";

    EditText editTextName;
    EditText editTextId ;
    EditText editTextAddress;
    Button buttonAddParcel;
    ParcelViewModel parcelViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel);
        Log.d(TAG, "333333333");

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        buttonAddParcel  = (Button) findViewById(R.id.buttonAddParcel);
        Log.d(TAG, "444444444444");

        parcelViewModel = ViewModelProviders.of(this).get(ParcelViewModel.class);



        parcelViewModel.getParcelChange().observe(this, new Observer<ParcelChange>() {
            @Override
            public void onChanged(ParcelChange parcelChange) {
                if (parcelChange.isSuccess()){
                    parcelAddedSuccessfully();
                }else {
                    parcelAddedFailure();
                }

            }
        });

        Log.d(TAG, "555555555");

        buttonAddParcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String id = editTextId.getText().toString().trim();
                String address = editTextAddress.getText().toString().trim();

                Parcel parcel = new Parcel(id, name, address);
                parcelViewModel.addParcel(parcel);

            }
        });

    }

    public void parcelAddedSuccessfully(){
        Toast.makeText(this, "Parcel added successfully", Toast.LENGTH_LONG).show();
    }
    public void parcelAddedFailure(){
        Toast.makeText(this, "Parcel added Failure", Toast.LENGTH_LONG).show();
    }
}
