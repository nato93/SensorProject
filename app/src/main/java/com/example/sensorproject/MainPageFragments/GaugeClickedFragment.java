package com.example.sensorproject.MainPageFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sensorproject.R;


public class GaugeClickedFragment extends Fragment {


    private EditText temperatureInfo;
    private Button chartButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gauge_clicked, container, false);
        configureImageButton(view);

        return view;

        //return inflater.inflate(R.layout.fragment_gauge_clicked, container, false);
        //temperatureInfo = findViewById(R.id.mTemperatureInfo);
        //chartButton  = view.findViewById(R.id.mChartButton);
    }

    private void configureImageButton(View view){

        ImageButton backButton = (ImageButton) view.findViewById(R.id.mBackButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.MainLayout, new MainPageFragment());
                fr.addToBackStack(null);
                Toast.makeText(getActivity(), "you successfully went back", Toast.LENGTH_SHORT).show();
                fr.commit();





/*                MainPageFragment nextFrag = new MainPageFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.balbalblayout, nextFrag, "findThisFragment")
                        .addToBackStack(null)
                        .commit();*/

            }
        });
    }
}
