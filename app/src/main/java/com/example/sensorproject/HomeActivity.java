package com.example.sensorproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    private TextView CoInput, TemperatureInput, HumidityInput;
    DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CoInput = findViewById(R.id.mCoInput);
        TemperatureInput = findViewById(R.id.mTempInput);
        HumidityInput = findViewById(R.id.mHumidInput);




        //mRef = new FirebaseDatabase("https://sensorproject-876ad.firebaseio.com/");

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        myRef.setValue("Hello, World!");





    }











}
