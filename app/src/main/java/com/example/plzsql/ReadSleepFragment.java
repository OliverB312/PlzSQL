package com.example.plzsql;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ReadSleepFragment extends Fragment {
    private TextView txRead;


    public ReadSleepFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_sleep, container, false);
        txRead = view.findViewById(R.id.txtRead);

        List<SleepRecord> sleepers = MainActivity.sleepDatabase.sleepDAO().getDataFromDB();

        String info = "";

        for(SleepRecord sleep : sleepers)
        {
            int ID = sleep.getRecordID();
            String sleeptime = sleep.getStartTime();
            String waketime = sleep.getEndTime();
            String startdate = sleep.getStartDate();
            String enddate = sleep.getEndDate();

            info = info +"\n\n"+"Id: "+ID+"\n Sleep Time: "+sleeptime+"\n Wake Time: "+waketime+"\n Start Date: "+startdate+"\n End Date: " + enddate;
        }

        txRead.setText(info);

        return view;
    }
}