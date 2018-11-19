package com.example.patryk.lab4;

import android.content.Context;

import com.example.patryk.lab4.dao.GroupDAO;
import com.example.patryk.lab4.dao.StudentDAO;
import com.example.patryk.lab4.dao.StudentGroupDAO;
import com.example.patryk.lab4.tables.Student;

import java.util.ArrayList;

public class DataManager {

    private DatabaseHelper myDb;

    public DataManager(Context context) {
        myDb = new DatabaseHelper(context, null, null, 1);

    }

    public StudentAdapter viewAllStudents(Context context) {
        ArrayList<Student> students = myDb.getStudentDAO().selectAll();
        StudentAdapter adapter = new StudentAdapter(context, students);
        return adapter;
    }


}
