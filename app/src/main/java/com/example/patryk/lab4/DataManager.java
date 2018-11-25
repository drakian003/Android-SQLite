package com.example.patryk.lab4;

import android.content.Context;
import android.widget.ListView;


import com.example.patryk.lab4.tables.Student;

import java.util.ArrayList;

public class DataManager {

    private DatabaseHelper myDb;
    private static DataManager instance;
    private Context mainContext;
    private ListView mainListView;

    public void setMainContext(Context mainContext) {
        this.mainContext = mainContext;
    }

    public void setMainListView(ListView mainListView) {
        this.mainListView = mainListView;
    }

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

    public void reloadStudents() {
        mainListView.setAdapter(null);
        mainListView.setAdapter(this.viewAllStudents(mainContext));
    }

    public void removeStudent(Student student){
        myDb.getStudentDAO().delete(student);
        reloadStudents();
    }

    public void editStudent(Student student){
        myDb.getStudentDAO().update(student);
    }

}
