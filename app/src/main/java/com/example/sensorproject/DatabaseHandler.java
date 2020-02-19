/*
package com.example.sensorproject;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

public class DatabaseHandler {

    private FirebaseAuth mAuth;


    public static String emailCredentials, passwordCredentials;
    public static String UID;


    //private FirebaseDatabase db = getInstance().getReference(users);
    private FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();

    // User type
    public static int USER_TYPE;
    public int getUserType() {
        return USER_TYPE;
    }
    public void setUserType(int i) { USER_TYPE = i; }

    // Collection references
    //private CollectionReference users = db.("users");
    //private CollectionReference restaurants = db.collection("restaurants");

    private static final String TAG = "CustomerSignupFrag";
    // private static final String KEY_ID = "UID";
    private static final String KEY_TYPE = "Type";
    private static final String KEY_NAME = "Name";
    private static final String KEY_LAST_NAME = "Last Name";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_ADDRESS = "Address";
    private static final String KEY_DESCRIPTION = "Description";
    private static final String KEY_TABLE_ID = "Table number";
    private static final String KEY_TABLE_SIZE = "Guests";




  */
/*  Create a new createAccount method which takes
    in an email address and password, validates
    them and then creates a new user with the
    createUserWithEmailAndPassword method. yoyo
*//*

*/
/*

    mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success");
                FirebaseUser user = mAuth.getCurrentUser();
                updateUI(user);
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
                updateUI(null);
            }

            // ...
        }
    });

*//*



}
*/
