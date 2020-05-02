package com.example.sensorproject.MainPageFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sensorproject.R;


public class GaugeClickedFragment extends Fragment {


    private TextView coText;
    private Button chartButton;

    private GaugeClickedListener listener;

    public interface GaugeClickedListener {
        void onInputGaugeClickedSent(CharSequence input);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gauge_clicked, container, false);
        configureImageButton(view);


        coText = view.findViewById(R.id.mInfoText);

        coText.setText(R.string.mCoInfo);

        //gaugeInfoText = view.findViewById(R.id.mInfoText);

        //gaugeInfoText = MainPageFragment.infoText;

        //CharSequence input = gaugeText.toString();
        //updateTextView(input);

        //gaugeText.setText(R.string.mCoInfo);
        //CharSequence input = gaugeText.getText();
        //updateTextView(gaugeText.toString());
        return view;
    }

    public void updateTextView(CharSequence newText){
        coText.setText(newText);
    }

    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof GaugeClickedListener){
            listener = (GaugeClickedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + "Must implement GaugeClickedListener");
        }
    }



    public void onDetach(){
        super.onDetach();
        listener = null;
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
