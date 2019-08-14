package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Listener.OnPersonClickListener;
import com.example.myapplication.Model.Person;
import com.example.myapplication.R;
import com.example.myapplication.ViewHolder.PersonRecyclerViewItemViewHolder;

import java.util.List;

public class PersonRecyclerViewAdapter extends RecyclerView.Adapter<PersonRecyclerViewItemViewHolder> {

    private List<Person> personList;
    private OnPersonClickListener onPersonClickListener;

    public PersonRecyclerViewAdapter(List<Person> personList, OnPersonClickListener onPersonClickListener) {
        this.personList = personList;
        this.onPersonClickListener = onPersonClickListener;
    }


    @NonNull
    @Override
    public PersonRecyclerViewItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item_view, parent, false);
        return new PersonRecyclerViewItemViewHolder(view, onPersonClickListener);    }

    @Override
    public void onBindViewHolder(@NonNull PersonRecyclerViewItemViewHolder holder, int position) {
        holder.setPersonName(personList.get(position).getName());
        holder.setPersonRelationship(personList.get(position).getRelationship());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }
}

