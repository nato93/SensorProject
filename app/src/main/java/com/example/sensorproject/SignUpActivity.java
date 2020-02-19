package com.example.sensorproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    public EditText signUpEmail, signUpPassword;
    private Button signUpButton;
    public FirebaseAuth mAuth;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();


        signUpEmail = findViewById(R.id.mSignUpEmail);
        signUpPassword = findViewById(R.id.mSignUpPassword);
        signUpButton = findViewById(R.id.mSignUpButton);



        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if the user was created successfully display a toast go to mainpage
                //else show an error and stay on the on the page

                String mSignUpEmail = signUpEmail.getText().toString();
                String mSignUpPassword = signUpPassword.getText().toString();
                mAuth.createUserWithEmailAndPassword(mSignUpEmail, mSignUpPassword);


                Intent signedUp = new Intent(SignUpActivity.this, MainPageActivity.class);
                startActivity(signedUp);
            }
        });






        }



}
