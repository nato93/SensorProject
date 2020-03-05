package com.example.sensorproject;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.sensorproject.MainPageFragments.MainPageFragment;

public class MainPageActivity extends AppCompatActivity {
    private TextView RoomView;



/*      1. need to set the spinners item one to the room name from the database
        2. need to add clicklistener on the gauges
        3. need to add fragments for when adding a new room
        4. need fragments for when gauges are clicked + when signing up + settings
        5. widget for timelines when a gauge is clicked*/





    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);


        RoomView = findViewById(R.id.mRoomView);
        FragmentManager fm = getSupportFragmentManager();
        final Fragment fragment = fm.findFragmentById(R.id.MainLayout);
        fm.beginTransaction().add(R.id.MainLayout, new MainPageFragment()).commit();


        //The spinner aka dropdown menu
        Spinner mySpinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainPageActivity.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.roomList));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);







    }//on create end
}
