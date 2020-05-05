package com.example.sensorproject;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.sensorproject.MainPageFragments.CoClickedFragment;
import com.example.sensorproject.MainPageFragments.MainPageFragment;

public class MainPageActivity extends AppCompatActivity implements MainPageFragment.MainPageListener, CoClickedFragment.GaugeClickedListener {
    private TextView RoomView;

    private MainPageFragment mainPageFragment;
    private CoClickedFragment gaugeClickedFragment;


    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.MainLayout, new MainPageFragment())
                .commit();


        RoomView = findViewById(R.id.mRoomView);

        mainPageFragment = new MainPageFragment();
        gaugeClickedFragment = new CoClickedFragment();


        //The spinner aka dropdown menu
        Spinner mySpinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainPageActivity.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.roomList));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

    }//on create end

    @Override
    public void onInputMainPageFragmentSent(CharSequence input) {
        gaugeClickedFragment.updateTextView(input);

    }

    @Override
    public void onInputGaugeClickedSent(CharSequence input) {

    }
}
