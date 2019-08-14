package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Adapter.PersonRecyclerViewAdapter;
import com.example.myapplication.Listener.OnPersonClickListener;
import com.example.myapplication.Model.Person;
import com.example.myapplication.ViewModel.PersonViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnPersonClickListener {

    private RecyclerView personsRecyclerView;
    private PersonViewModel personViewModel;
    private PersonRecyclerViewAdapter personRecyclerViewAdapter;
    private List<Person> myDataSourceOfPersons;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataSourceOfPersons = new ArrayList<>();
        personRecyclerViewAdapter = new PersonRecyclerViewAdapter(myDataSourceOfPersons, this);

        personViewModel = ViewModelProviders.of(this).get(PersonViewModel.class);
        personViewModel.getAllWords().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                if (people.size() != 0) {
                    personRecyclerViewAdapter.setPersonList(people);
                }
            }
        });


        personsRecyclerView = findViewById(R.id.personsRecyclerView);
        personsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        personsRecyclerView.setAdapter(personRecyclerViewAdapter);
    }

    public void personsRecyclerView(View view) {

    }


    @Override
    public void onPersonClicked(int position) {

    }
}
