package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.Model.Person;

public class ImpressionActivity extends AppCompatActivity {

    private Person incomingPerson;
    private TextView impressionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impression);

        impressionTextView = findViewById(R.id.impression_text_view);
        Intent incomingIntent = getIntent();


        if (incomingIntent.hasExtra("KEY")) {
            incomingPerson = incomingIntent.getParcelableExtra("KEY");
            impressionTextView.setText(incomingPerson.getFirstImpression());
        }
    }

    public void goBackToPersonsListActivity(View view) {
        finish();
    }
}
