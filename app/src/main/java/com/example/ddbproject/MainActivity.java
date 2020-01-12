package com.example.ddbproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ddbproject.UI.AddParcelActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "AddParcelActivity";

    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "1111111111");

        buttonAdd  = (Button) findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddParcelActivity.class);
                Log.d(TAG, "2222222222");
                startActivity(intent);
            }
        });
    }
}
