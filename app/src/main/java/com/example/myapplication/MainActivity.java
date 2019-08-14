package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView personsRecyclerView;
//    private PersonRecyclerViewAdapter personRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personsRecyclerView = findViewById(R.id.personsRecyclerView);
        personsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        personsRecyclerView.setAdapter(personRecyclerViewAdapter);
    }

    public void personsRecyclerView(View view) {

    }


}
