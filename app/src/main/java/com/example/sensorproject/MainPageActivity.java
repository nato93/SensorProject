package com.example.sensorproject;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    private TextView CoInput, TemperatureInput, HumidityInput, RoomView;
    DatabaseReference reff;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainPageActivity.this,
        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.roomList));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        // the gauge
        final GaugeView gv_co = (GaugeView) findViewById(R.id.gv_co);

        gv_co.setShowRangeValues(true);
        gv_co.setTargetValue(0);
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


        TemperatureInput = findViewById(R.id.mTempInput);
        HumidityInput = findViewById(R.id.mHumidInput);
        RoomView = findViewById(R.id.mRoomView);


        reff = FirebaseDatabase.getInstance().getReference().child("users").child("user_one");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String co=dataSnapshot.child("co").getValue().toString();
                String temperature=dataSnapshot.child("temperature").getValue().toString();
                String humidity=dataSnapshot.child("humidity").getValue().toString();
                String room=dataSnapshot.child("room").getValue().toString();
                gv_co.setTargetValue(Float.parseFloat(co));
                //CoInput.setText(co);
                TemperatureInput.setText(temperature);
                HumidityInput.setText(humidity);
                RoomView.setText(room);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }

        });



    }//on create end

}
