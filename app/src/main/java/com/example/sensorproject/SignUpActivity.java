package com.example.sensorproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    public EditText signUpEmail, signUpPassword;
    private Button signUpButton;
    public FirebaseAuth firebaseAuth;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

// ...
// Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();


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

                //register user
                firebaseAuth.createUserWithEmailAndPassword(mSignUpEmail,mSignUpPassword)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                //Log.d(TAG, "New user registration: " + task.isSuccessful());
                                Toast.makeText(SignUpActivity.this,"You successfully created your account!", Toast.LENGTH_SHORT).show();
                                //Intent signedUp = new Intent(SignUpActivity.this, MainPageActivity.class);
                                //startActivity(signedUp);

                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignUpActivity.this,"Somethings went wrong!" + task.getException(), Toast.LENGTH_SHORT).show();
                                    //SignUpActivity.this.Toast.makeText("Authentication failed. " + task.getException());
                                } else {
                                    SignUpActivity.this.startActivity(new Intent(SignUpActivity.this, MainPageActivity.class));
                                    SignUpActivity.this.finish();
                                }
                            }
                        });

            }
        });

        }
}
