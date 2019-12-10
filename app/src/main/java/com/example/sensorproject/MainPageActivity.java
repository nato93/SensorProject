package com.example.sensorproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sensorproject.MainPageFragments.GaugeClickedFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ntt.customgaugeview.library.GaugeView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainPageActivity extends AppCompatActivity {
    private TextView RoomView;
    DatabaseReference reff;



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




        // the gauge
        final GaugeView mGv_co = findViewById(R.id.gv_co);
        final GaugeView mGv_temp = findViewById(R.id.gv_humid);
        final GaugeView mGv_humid = findViewById(R.id.gv_temp);


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
        timer.start();
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


//CLICK LISTENERS

        mGv_co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainPageActivity.this, "ITS WORKING", Toast.LENGTH_SHORT).show();


                //the content is currently inside the container: container_main
                // when the CO gauge is clicked i want it to open the fragment: GaugeClickedFragment
                // with the layout: container_gauge

/*
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragment = fm.findFragmentById(R.id.container_gauge);
                fm.beginTransaction().add(R.id.container_gauge, new GaugeClickedFragment()).commit();


                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container_main, new GaugeClickedFragment());
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();*/


                // making the fragment hhh

                GaugeClickedFragment gaugeClickedFragment = new GaugeClickedFragment();
                FragmentManager fm = getSupportFragmentManager();

                fm.beginTransaction().replace(R.id.container_gauge, gaugeClickedFragment).commit();


            }
        });

        mGv_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainPageActivity.this, "ITS WORKING", Toast.LENGTH_SHORT).show();

            }
        });


        mGv_humid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainPageActivity.this, "ITS WORKING", Toast.LENGTH_SHORT).show();

            }
        });


    }//on create end
}
