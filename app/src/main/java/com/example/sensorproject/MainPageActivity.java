package com.example.sensorproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainPageActivity extends AppCompatActivity {
    private TextView CoInput, TemperatureInput, HumidityInput;
    DatabaseReference reff;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);


        CoInput = findViewById(R.id.mCoInput);
        TemperatureInput = findViewById(R.id.mTempInput);
        HumidityInput = findViewById(R.id.mHumidInput);


        reff = FirebaseDatabase.getInstance().getReference().child("users").child("user_one");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String co=dataSnapshot.child("co").getValue().toString();
                String temperature=dataSnapshot.child("temperature").getValue().toString();
                String humidity=dataSnapshot.child("humidity").getValue().toString();
                CoInput.setText(co);
                TemperatureInput.setText(temperature);
                HumidityInput.setText(humidity);
                //   mBook.setText(books);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
