package com.example.myapplication.AsyncTask;

import android.os.AsyncTask;

import com.example.myapplication.Dao.PersonDao;
import com.example.myapplication.Model.Person;

public class UpdateAsyncTask extends AsyncTask<Person, Void, Void> {

    private PersonDao personDao;

    public UpdateAsyncTask(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    protected Void doInBackground(Person... people) {
        personDao.updatePerson(people[0]);
        return null;
    }
}
