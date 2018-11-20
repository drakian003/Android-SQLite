package com.example.patryk.lab4;

import android.content.Context;

import com.example.patryk.lab4.dao.GroupDAO;
import com.example.patryk.lab4.dao.StudentDAO;
import com.example.patryk.lab4.dao.StudentGroupDAO;
import com.example.patryk.lab4.tables.Student;

import java.util.ArrayList;

public class DataManager {

    private DatabaseHelper myDb;
    private static DataManager instance;

    private DataManager() {
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }

        return instance;
    }

    public void setMyDb(DatabaseHelper myDb) {
        this.myDb = myDb;
    }

    public StudentAdapter viewAllStudents(Context context) {
        ArrayList<Student> students = myDb.getStudentDAO().selectAll();
        StudentAdapter adapter = new StudentAdapter(context, students);
        return adapter;
    }


}
