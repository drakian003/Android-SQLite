package com.example.patryk.lab4;

import android.content.Context;

import com.example.patryk.lab4.dao.GroupDAO;
import com.example.patryk.lab4.dao.StudentDAO;
import com.example.patryk.lab4.dao.StudentGroupDAO;
import com.example.patryk.lab4.tables.Student;

import java.util.ArrayList;

public class DataManager {
    private StudentDAO studentDAO;
    private GroupDAO groupDAO;
    private StudentGroupDAO studentGroupDAO;
    private DatabaseHelper myDb;

    public DataManager(Context context) {
        myDb = new DatabaseHelper(context, null, null, 1);
        studentDAO = new StudentDAO();
    }

    public StudentAdapter viewAllStudents(Context context) {
        ArrayList<Student> students = studentDAO.selectAll();
        StudentAdapter adapter = new StudentAdapter(context, students);
        return adapter;

    }
}
