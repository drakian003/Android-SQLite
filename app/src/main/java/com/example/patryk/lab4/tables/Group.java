package com.example.patryk.lab4.tables;

import android.database.sqlite.SQLiteDatabase;

public class Group {

    public static final String TABLE_NAME = "Grupy";
    public static final String ID_COLUMN = "Id_grupy";
    public static final String NAME_COLUMN = "Nazwa";
    private int id;
    private String name;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
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

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME_COLUMN + " TEXT)");
    }

    public static void onUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }


}
