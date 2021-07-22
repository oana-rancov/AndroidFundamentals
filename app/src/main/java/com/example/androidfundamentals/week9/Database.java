package com.example.androidfundamentals.week9;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@androidx.room.Database(entities = {PersonEntity.class}, version = 2) //inainte de migrare era version=1
public abstract class Database extends RoomDatabase {
private final static String  MY_DATABASE = "my_database";
    private static Database DATABASE;

    public abstract PersonDao personDao();

    //for migration
    static final Migration MIGRATION1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Person " + " ADD COLUMN nickName TEXT");
        }
    };

    public static Database getDatabase(Context context) {
        if (DATABASE == null) {
            DATABASE = Room.databaseBuilder(context,
                    Database.class,
                    MY_DATABASE)
                    .addMigrations(MIGRATION1_2) //for migration
                    .fallbackToDestructiveMigration() //for migration
                    .build();
        }
        return DATABASE;
    }

}
