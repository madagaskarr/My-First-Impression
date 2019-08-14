package com.example.myapplication.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.myapplication.Dao.PersonDao;
import com.example.myapplication.Database.PersonsDatabase;
import com.example.myapplication.Model.Person;

import java.util.List;

public class PersonRepository {

    private PersonDao personDao;
    private LiveData<List<Person>> allPersons;

    public PersonRepository(Application application) {
        PersonsDatabase db = PersonsDatabase.getDatabase(application);
        personDao = db.personDao();
        allPersons = personDao.getAllPeople();
    }

    public LiveData<List<Person>> getAllWords() {
        return allPersons;
    }

    public void insertPersonTask(Person person){
//        new InsertAsyncTask(personDao).execute(person);
    }

    public void updatePersonTask(Person person){
//        new UpdateAsyncTask(personDao).execute(person);
    }

    public void deletePersonTask(Person person){
//        new UpdateAsyncTask(personDao).execute(person);
    }


}
