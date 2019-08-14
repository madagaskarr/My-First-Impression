package com.example.myapplication.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Listener.OnPersonClickListener;
import com.example.myapplication.R;

public class PersonRecyclerViewItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView personNameTextView;
    private TextView personRelationshipTextView;
    private OnPersonClickListener onPersonClickListener;


    public PersonRecyclerViewItemViewHolder(@NonNull View itemView, OnPersonClickListener onPersonClickListener) {
        super(itemView);

        this.personNameTextView = itemView.findViewById(R.id.person_name_text_view);
        this.personRelationshipTextView = itemView.findViewById(R.id.person_relationship_text_view);
        this.onPersonClickListener = onPersonClickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        onPersonClickListener.onPersonClicked(getAdapterPosition());
    }

    public void setPersonName(String personName) {
        this.personNameTextView.setText(personName);
    }

    public String getPersonName() {
        return this.personNameTextView.getText().toString();
    }

    public void setPersonRelationship(String personRelationship) {
        this.personRelationshipTextView.setText(personRelationship);
    }

    public String getPersonRelationship() {
        return this.personRelationshipTextView.getText().toString();
    }
}

