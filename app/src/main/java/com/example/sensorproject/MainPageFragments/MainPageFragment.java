package com.example.sensorproject.MainPageFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensorproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ntt.customgaugeview.library.GaugeView;

import static java.lang.Float.valueOf;


public class MainPageFragment extends Fragment {

    DatabaseReference reff;
    static TextView infoText;

    private MainPageListener listener;

    public interface MainPageListener {
        void onInputMainPageFragmentSent(CharSequence input);
    }

    public MainPageFragment() {
        // Required empty public constructor
    }



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainPageFragment newInstance(String param1, String param2) {
        MainPageFragment fragment = new MainPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    //private OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reff = FirebaseDatabase.getInstance().getReference().child("Climate");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main_page, container, false);
        // Inflate the layout for this fragment

        infoText = view.findViewById(R.id.mInfoText);


        final GaugeView mGv_co = view.findViewById(R.id.gv_co);
        final GaugeView mGv_temp = view.findViewById(R.id.gv_humid);
        final GaugeView mGv_humid = view.findViewById(R.id.gv_temp);

        mGv_co.setShowRangeValues(true);
        mGv_co.setTargetValue(0);
        mGv_humid.setShowRangeValues(true);
        mGv_humid.setTargetValue(0);
        mGv_temp.setShowRangeValues(true);
        mGv_temp.setTargetValue(0);

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String co = dataSnapshot.child("Co").getValue().toString();
                String temperature = dataSnapshot.child("Temperature").getValue().toString();
                String humidity = dataSnapshot.child("Humidity").getValue().toString();

                mGv_co.setTargetValue(Float.parseFloat(co));
                mGv_humid.setTargetValue(Float.parseFloat(humidity));
                mGv_temp.setTargetValue(Float.parseFloat(temperature));

                // send a notification

                if(Float.parseFloat((temperature)) > 25){
                    Toast.makeText(getActivity(),"It is too hot!",Toast.LENGTH_SHORT).show();
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
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.MainLayout, new CoClickedFragment()).commit();
                //infoText.setText(R.string.mCoInfo);
               // CharSequence input = infoText.getText();
                //listener.onInputMainPageFragmentSent(input);
            }
        });

        mGv_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"IT IS WORKING TUUDOLOO!",Toast.LENGTH_SHORT).show();
                //final Fragment fragment = fm.findFragmentById(R.id.MainLayout);
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.MainLayout, new TempClickedFragment()).commit();
                //infoText.setText(R.string.mTemperatureInfo);
            }
        });

        mGv_humid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.MainLayout, new HumClickedFragment()).commit();
                //Toast.makeText(MainPageActivity.this, "ITS WORKING", Toast.LENGTH_SHORT).show();

                //infoText.setText(R.string.mHumidityInfo);
                //CharSequence input = infoText.toString();
                //listener.onInputMainPageFragmentSent(input);
                //infoText.setText(R.string.mHumidityInfo);
                //updateTextView(infoText);

                Toast.makeText(getActivity(), "YOU CLICKED HUMIDITY", Toast.LENGTH_SHORT).show();



            }
        });
        return view;
    } //OnCreate ends

    public void updateTextView(TextView newText){
        infoText = newText;

    }



    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof MainPageListener){
            listener = (MainPageListener) context;
        } else {
            throw new RuntimeException(context.toString()
            + "Must implement MainPageListener");
        }

    }

    public void onDetach(){
        super.onDetach();
        listener = null;
    }


/**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     *//*

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
*/
}       // End of fragment
