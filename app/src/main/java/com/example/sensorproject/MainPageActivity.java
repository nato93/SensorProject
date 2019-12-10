package com.example.sensorproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

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



        //The spinner aka dropdown menu
        Spinner mySpinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainPageActivity.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.roomList));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        RoomView = findViewById(R.id.mRoomView);





/*
        CountDownTimer timer = new CountDownTimer(10000, 2) {
            @Override
            public void onTick(long millisUntilFinished) {
                //gv_co.setTargetValue(Float.valueOf(90));
            }

            @Override
            public void onFinish() {
               // gv_co.setTargetValue(Float.valueOf(String.valueOf(CoInput)));
            }
        };
        timer.start();
*/





    }//on create end
}
