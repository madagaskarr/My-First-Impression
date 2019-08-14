package com.example.myapplication.AsyncTask;

import android.os.AsyncTask;

import com.example.myapplication.Dao.PersonDao;
import com.example.myapplication.Model.Person;

public class InsertAsyncTask extends AsyncTask<Person, Void, Void> {

    private PersonDao personDao;

    public InsertAsyncTask(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    protected Void doInBackground(Person... people) {
        personDao.insertPerson(people[0]);
        return null;
    }
}
