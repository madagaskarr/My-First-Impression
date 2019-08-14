package com.example.myapplication.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person_table")
public class Person implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "relationship")
    private String relationship;

    @ColumnInfo(name = "first_impression")
    private String firstImpression;


    public Person(String name, String relationship, String firstImpression) {
        this.name = name;
        this.relationship = relationship;
        this.firstImpression = firstImpression;
    }

    @Ignore
    public Person() {

    }

    protected Person(Parcel in) {
        id = in.readInt();
        name = in.readString();
        relationship = in.readString();
        firstImpression = in.readString();
    }

    public static final Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(relationship);
        parcel.writeString(firstImpression);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getFirstImpression() {
        return firstImpression;
    }

    public void setFirstImpression(String firstImpression) {
        this.firstImpression = firstImpression;
    }
}

