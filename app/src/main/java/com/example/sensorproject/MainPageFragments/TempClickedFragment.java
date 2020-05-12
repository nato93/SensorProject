package com.example.sensorproject.MainPageFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sensorproject.R;


public class TempClickedFragment extends Fragment {


    private TextView tempText, tempView;
    //private Button chartButton;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_temp_clicked, container, false);
        configureImageButton(view);


        tempText = view.findViewById(R.id.mInfoText);
        tempView = view.findViewById(R.id.mTempView);

        tempText.setText(R.string.mTemperatureInfo);

        //gaugeInfoText = view.findViewById(R.id.mInfoText);

        //gaugeInfoText = MainPageFragment.infoText;

        //CharSequence input = gaugeText.toString();
        //updateTextView(input);

        //gaugeText.setText(R.string.mCoInfo);
        //CharSequence input = gaugeText.getText();
        //updateTextView(gaugeText.toString());
        return view;
    }





    private void configureImageButton(View view){

        ImageButton backButton = (ImageButton) view.findViewById(R.id.mBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.MainLayout, new MainPageFragment());
                fr.addToBackStack(null);
                //Toast.makeText(getActivity(), "you successfully went back", Toast.LENGTH_SHORT).show();
                fr.commit();
            }
        });
    }
}
