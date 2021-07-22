package com.example.androidfundamentals.week9;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {PersonEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {
private final static String  MY_DATABASE = "my_database";
    private static Database DATABASE;

    public abstract PersonDao personDao();

    public static Database getDatabase(Context context) {
        if (DATABASE == null) {
            DATABASE = Room.databaseBuilder(context,
                    Database.class,
                    MY_DATABASE)
                    .build();
        }
        return DATABASE;
    }

}
