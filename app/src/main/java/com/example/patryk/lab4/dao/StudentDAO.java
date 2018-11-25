package com.example.patryk.lab4.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.patryk.lab4.interfaces.IStudentDAO;
import com.example.patryk.lab4.tables.Student;

import java.util.ArrayList;

public class StudentDAO implements IStudentDAO {

    String tableName = Student.TABLE_NAME;
    String[] projection;
    protected SQLiteDatabase db;

    public StudentDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public ArrayList<Student> selectAll() {

        Cursor cursor = db.query(
                this.tableName,         // The table to query
                this.projection,        // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,          // don't group the rows
                null,           // don't filter by row groups
                null               // The sort order
        );

        ArrayList<Student> students = new ArrayList<Student>();

        while (cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Student.ID_COLUMN));
            String itemName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Student.NAME_COLUMN));
            String itemLastName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Student.LAST_NAME_COLUMN));

            students.add(new Student((int) itemId, itemName, itemLastName));
        }
        cursor.close();

        return students;
    }

    public Student selectById(int id) {
        String[] selectionArgs = {id + ""};
        Cursor cursor = db.query(
                this.tableName,         // The table to query
                this.projection,        // The array of columns to return (pass null to get all)
                Student.ID_COLUMN + " = ?",              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,          // don't group the rows
                null,           // don't filter by row groups
                null               // The sort order
        );

        long itemId = 0;
        String itemName = "";
        String itemLastName = "";
        while (cursor.moveToNext()) {
            itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(Student.ID_COLUMN));
            itemName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Student.NAME_COLUMN));
            itemLastName = cursor.getString(
                    cursor.getColumnIndexOrThrow(Student.LAST_NAME_COLUMN));
        }
        cursor.close();

        Student student = new Student((int) itemId, itemName, itemLastName);
        return student;

    }

    public int insert(Student student) {
        ContentValues values = new ContentValues();

        values.put(Student.NAME_COLUMN, student.getName());
        values.put(Student.LAST_NAME_COLUMN, student.getLastName());

        return (int) db.insert(this.tableName, null, values);

    }

    public boolean update(Student student) {
        ContentValues values = new ContentValues();

        values.put(Student.NAME_COLUMN, student.getName());
        values.put(Student.LAST_NAME_COLUMN, student.getLastName());
        return db.update(Student.TABLE_NAME, values, Student.ID_COLUMN + "=" + student.getId(), null) > 0;
    }


    public boolean delete(Student student) {
        return db.delete(Student.TABLE_NAME, Student.ID_COLUMN + "=" + student.getId(), null) > 0;

    }


}