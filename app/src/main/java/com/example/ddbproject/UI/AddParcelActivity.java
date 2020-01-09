package com.example.ddbproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.ddbproject.R;

public class AddParcelActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextId ;
    EditText editTextAddress;
    Button buttonAddParcel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_parcel);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);

        buttonAddParcel  = (Button) findViewById(R.id.buttonAddParcel);

    }
}
