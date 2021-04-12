package com.example.plzsql;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SleepDAO {

    @Insert
    public void addRecord(SleepRecord sleep);

    @Query("SELECT * FROM sleepy")
    public List<SleepRecord> getDataFromDB();
}
