package com.example.sensorproject;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ntt.customgaugeview.library.GaugeView;

public class MainPageActivity extends AppCompatActivity {
    private TextView RoomView;
    DatabaseReference reff;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        Spinner mySpinner = findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainPageActivity.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.roomList));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        // the gauge
        final GaugeView mGv_co = findViewById(R.id.gv_co);
        final GaugeView mGv_temp = findViewById(R.id.gv_humid);
        final GaugeView mGv_humid = findViewById(R.id.gv_temp);
        RoomView = findViewById(R.id.mRoomView);


        mGv_co.setShowRangeValues(true);
        mGv_co.setTargetValue(0);

        mGv_humid.setShowRangeValues(true);
        mGv_humid.setTargetValue(0);

        mGv_temp.setShowRangeValues(true);
        mGv_temp.setTargetValue(0);


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
        //timer.start();
*/




        reff = FirebaseDatabase.getInstance().getReference().child("users").child("user_one");
        reff.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {
                    String co = dataSnapshot.child("co").getValue().toString();
                    String temperature = dataSnapshot.child("temperature").getValue().toString();
                    String humidity = dataSnapshot.child("humidity").getValue().toString();
                    String room = dataSnapshot.child("room").getValue().toString();
                    mGv_co.setTargetValue(Float.parseFloat(co));
                    mGv_temp.setTargetValue(Float.parseFloat(temperature));
                    mGv_humid.setTargetValue(Float.parseFloat(humidity));
                    //CoInput.setText(co);
                    RoomView.setText(room);
                }
                catch (NullPointerException e){
                    System.out.print("NullPointerException caught");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }

        });



    }//on create end

}
