package com.example.plzsql;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SleepRecord.class}, version = 1, exportSchema = false)
public abstract class SleepDatabase extends RoomDatabase {

    public abstract SleepDAO sleepDAO();
}
