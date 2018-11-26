package com.example.patryk.lab4.tables;

import android.database.sqlite.SQLiteDatabase;

public class StudentGroupTable {

    public static final String TABLE_NAME = "Grupy_studenta";
    public static final String ID_COLUMN = "Id";
    public static final String STUDENT_ID_COLUMN = "Id_studenta";
    public static final String GROUP_ID_COLUMN = "Id_grupy";

    public StudentGroupTable() {

    }

    public static void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "
                + TABLE_NAME + "("
                + ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + STUDENT_ID_COLUMN + " INTEGER, "
                + GROUP_ID_COLUMN + " INTEGER, "
                + "CONSTRAINT FK_Student FOREIGN KEY (" + STUDENT_ID_COLUMN + ") REFERENCES " + Student.TABLE_NAME + "(" + Student.ID_COLUMN + ") ON DELETE CASCADE,"
                + "CONSTRAINT FK_Group FOREIGN KEY (" + GROUP_ID_COLUMN + ") REFERENCES " + Group.TABLE_NAME + "(" + Group.ID_COLUMN + ") ON DELETE CASCADE)");

    }

    public static void onUpgrade(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
}
