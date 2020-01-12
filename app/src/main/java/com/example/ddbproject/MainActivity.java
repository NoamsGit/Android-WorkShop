package com.example.ddbproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ddbproject.UI.AddParcelActivity;
import com.example.ddbproject.UI.HistoryParcelsActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "AddParcelActivity";

    Button buttonAdd;
    Button buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "1111111111000");

        buttonAdd  = (Button) findViewById(R.id.buttonAdd);
        buttonList = (Button) findViewById(R.id.buttonList);

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryParcelsActivity.class);
                Log.d(TAG, "2222222222000");
                startActivity(intent);
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddParcelActivity.class);
                Log.d(TAG, "33333330000");
                startActivity(intent);
            }
        });
    }
}
