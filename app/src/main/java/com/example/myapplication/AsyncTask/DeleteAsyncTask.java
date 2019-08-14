package com.example.myapplication.AsyncTask;

import android.os.AsyncTask;

import com.example.myapplication.Dao.PersonDao;
import com.example.myapplication.Model.Person;

public class DeleteAsyncTask  extends AsyncTask<Person, Void, Void> {

    private PersonDao personDao;

    public DeleteAsyncTask(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    protected Void doInBackground(Person... people) {
        personDao.deletePerson(people[0]);
        return null;
    }
}

