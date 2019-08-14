package com.example.myapplication.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.Model.Person;
import com.example.myapplication.Repository.PersonRepository;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {

    private PersonRepository personRepository;

    private LiveData<List<Person>> allPersons;

    public PersonViewModel (Application application) {
        super(application);
        personRepository = new PersonRepository(application);
        allPersons = personRepository.getAllWords();
    }

    public LiveData<List<Person>> getAllWords() {
        return allPersons;
    }

    public void insert(Person person) {
        personRepository.insertPersonTask(person);
    }

    public void update(Person person) {
        personRepository.updatePersonTask(person);
    }

    public void delete(Person person) {
        personRepository.deletePersonTask(person);
    }
}

