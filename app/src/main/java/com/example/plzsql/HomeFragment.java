package com.example.plzsql;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button bnHome, bnHomeRead;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        bnHome = view.findViewById(R.id.btnHome);
        bnHome.setOnClickListener(this);

        bnHomeRead = view.findViewById(R.id.btnHome2);
        bnHomeRead.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnHome:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_layhome, new InsertSleepFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.btnHome2:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_layhome, new ReadSleepFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }
}