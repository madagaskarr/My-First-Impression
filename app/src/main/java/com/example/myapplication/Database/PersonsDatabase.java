package com.example.myapplication.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.Dao.PersonDao;
import com.example.myapplication.Model.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class PersonsDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "person_database";

    public abstract PersonDao personDao();


    private static volatile PersonsDatabase INSTANCE;

    public static PersonsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PersonsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PersonsDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

