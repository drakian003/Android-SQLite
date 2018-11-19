package com.example.patryk.lab4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.patryk.lab4.tables.Group;
import com.example.patryk.lab4.tables.StudentGroupTable;
import com.example.patryk.lab4.tables.Student;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LAB4.db";
    private SQLiteDatabase db;


    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, version);
        db = getWritableDatabase();
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Student.onCreate(db);
        Group.onCreate(db);
        StudentGroupTable.onCreate(db);
        insertSomeTestData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Student.onUpgrade(db);
        Group.onUpgrade(db);
        StudentGroupTable.onUpgrade(db);
        onCreate(db);
    }

    private void insertSomeTestData(SQLiteDatabase db){
        db.execSQL("INSERT INTO STUDENCI("+Student.ID_COLUMN+", "+Student.NAME_COLUMN+", "+Student.LAST_NAME_COLUMN+") VALUES (1, 'Patryk', 'Juszczynka')");
    }


}
