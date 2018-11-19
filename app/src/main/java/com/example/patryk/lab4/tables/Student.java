package com.example.patryk.lab4.tables;

import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Student {

    public static final String TABLE_NAME = "Studenci";
    public static final String ID_COLUMN = "Id_studenta";
    public static final String NAME_COLUMN = "Imię";
    public static final String LAST_NAME_COLUMN = "Nazwisko";

    private int id;
    private String name;
    private String lastName;
    private ArrayList<Group> groups;


    public Student(int id, String firstName, String lastName, ArrayList<Group> groups) {
        this.id = id;
        this.name = firstName;
        this.lastName = lastName;
        this.groups = groups;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME_COLUMN + " TEXT, "+LAST_NAME_COLUMN+" TEXT)");
    }

    public static void onUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }


}
