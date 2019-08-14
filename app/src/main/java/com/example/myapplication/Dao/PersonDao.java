package com.example.myapplication.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Model.Person;

import java.util.List;

@Dao
public interface PersonDao {

    @Insert
    void insertPerson(Person person);

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);

    @Query("SELECT * FROM person_table")
    LiveData<List<Person>> getAllPeople();
}
