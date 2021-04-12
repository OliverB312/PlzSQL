package com.example.plzsql;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertSleepFragment extends Fragment {
    private EditText Sleeptime, WakeTime, StartDate, EndDate;
    private Button bnSave;

    public InsertSleepFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_sleep, container, false);

        Sleeptime = view.findViewById(R.id.txtSleep);
        WakeTime = view.findViewById(R.id.txtWake);
        StartDate = view.findViewById(R.id.txtStart);
        EndDate = view.findViewById(R.id.txtEnd);
        bnSave = view.findViewById(R.id.btnAdd);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sleeptime = Sleeptime.getText().toString();
                String waketime = WakeTime.getText().toString();
                String startdate = StartDate.getText().toString();
                String enddate = EndDate.getText().toString();

                SleepRecord sleep = new SleepRecord();
                sleep.setStartTime(sleeptime);
                sleep.setEndTime(waketime);
                sleep.setStartDate(startdate);
                sleep.setEndDate(enddate);

                MainActivity.sleepDatabase.sleepDAO().addRecord(sleep);
                Toast.makeText(getActivity(), "Inserted successfully",Toast.LENGTH_SHORT).show();

                Sleeptime.setText("");
                WakeTime.setText("");
                StartDate.setText("");
                EndDate.setText("");
                bnSave.setText("");
            }
        });


        return view;


    }
}