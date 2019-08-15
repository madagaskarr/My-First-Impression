package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.myapplication.Adapter.PersonRecyclerViewAdapter;
import com.example.myapplication.Listener.OnPersonClickListener;
import com.example.myapplication.Model.Person;
import com.example.myapplication.ViewModel.PersonViewModel;

import java.util.ArrayList;
import java.util.List;

public class PersonsListActivity extends AppCompatActivity implements OnPersonClickListener {

    private RecyclerView personsRecyclerView;
    private PersonViewModel personViewModel;
    private PersonRecyclerViewAdapter personRecyclerViewAdapter;
    private List<Person> myDataSourceOfPersons;
    private EditText searchEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDataSourceOfPersons = new ArrayList<>();
        searchEditText = findViewById(R.id.search_edit_text);
        personRecyclerViewAdapter = new PersonRecyclerViewAdapter(myDataSourceOfPersons, this);

        personViewModel = ViewModelProviders.of(this).get(PersonViewModel.class);
        personViewModel.getAllWords().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> people) {
                if (people.size() != 0) {
                    myDataSourceOfPersons = people;
                    personRecyclerViewAdapter.setPersonList(myDataSourceOfPersons);
                }
            }
        });


        personsRecyclerView = findViewById(R.id.personsRecyclerView);
        personsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        personsRecyclerView.setAdapter(personRecyclerViewAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                personViewModel.delete(personRecyclerViewAdapter.getPersonAt(viewHolder.getAdapterPosition()));

            }
        }).attachToRecyclerView(personsRecyclerView);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {

                filter(s.toString());
            }
        });
    }

    void filter(String text){
        List<Person> temp = new ArrayList();
        for(Person d: myDataSourceOfPersons){

            if(d.getName().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        personRecyclerViewAdapter.setPersonList(temp);
    }





    public void addNewPerson(View view) {

        final Person person = new Person();

        LinearLayout alertLayout = new LinearLayout(this);
        alertLayout.setOrientation(LinearLayout.VERTICAL);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Add new person");

        final EditText nameInput = new EditText(this);
        nameInput.setInputType(InputType.TYPE_CLASS_TEXT);
        nameInput.setHint(Html.fromHtml("<small>" + "enter name..." + "</small>"));
        alertLayout.addView(nameInput);

        final EditText relationshipInput = new EditText(this);
        relationshipInput.setInputType(InputType.TYPE_CLASS_TEXT);
        relationshipInput.setHint(Html.fromHtml("<small>" + "enter your relationship to him" + "</small>"));
        alertLayout.addView(relationshipInput);

        final EditText impressionInput = new EditText(this);
        impressionInput.setInputType(InputType.TYPE_CLASS_TEXT);
        impressionInput.setSingleLine(false);
        impressionInput.setHint(Html.fromHtml("<small>" + "enter description... this is multiline, so you have plenty of place in case you really want to write..." + "</small>"));
        alertLayout.addView(impressionInput);
        alertDialog.setView(alertLayout);

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                person.setName(nameInput.getText().toString());
                person.setFirstImpression(impressionInput.getText().toString());
                person.setRelationship(relationshipInput.getText().toString());
                personViewModel.insert(person);

            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();

    }


    @Override
    public void onPersonClicked(int position) {
        Intent impressionActivityIntent = new Intent(this,ImpressionActivity.class);
        impressionActivityIntent.putExtra("KEY", myDataSourceOfPersons.get(position));
        startActivity(impressionActivityIntent);

    }
}
