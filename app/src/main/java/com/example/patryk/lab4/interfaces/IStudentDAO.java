package com.example.patryk.lab4.interfaces;

import android.database.sqlite.SQLiteDatabase;

import com.example.patryk.lab4.tables.Student;

import java.util.ArrayList;

public interface IStudentDAO {
    public ArrayList<Student> selectAll();

    public Student selectById(int id);

    public int insert(Student student);

    public boolean update(Student student);

    public boolean delete(Student student);
}
