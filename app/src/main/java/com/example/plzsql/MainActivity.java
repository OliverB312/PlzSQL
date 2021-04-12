package com.example.plzsql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static FragmentManager fragmentManager;
    public static SleepDatabase sleepDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        sleepDatabase = Room.databaseBuilder(getApplicationContext(), SleepDatabase.class, "sleepdb").allowMainThreadQueries().build();

        if(findViewById(R.id.fragment_layhome) != null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

        }
        fragmentManager.beginTransaction().add(R.id.fragment_layhome, new HomeFragment()).commit();
    }
}