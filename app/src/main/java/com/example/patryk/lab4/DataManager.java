package com.example.patryk.lab4;

import android.content.Context;
import android.widget.ListView;


import com.example.patryk.lab4.Adapters.GroupAdapter;
import com.example.patryk.lab4.Adapters.StudentAdapter;
import com.example.patryk.lab4.tables.Group;
import com.example.patryk.lab4.tables.Student;

import java.util.ArrayList;

public class DataManager {

    private DatabaseHelper myDb;
    private static DataManager instance;
    private Context mainContext;
    private ListView mainListView;
    private Context secondContext;
    private ListView secondListView;


    public void setMainContext(Context mainContext) {
        this.mainContext = mainContext;
    }

    public void setMainListView(ListView mainListView) {
        this.mainListView = mainListView;
    }

    public void setSecondContext(Context secondContext) {
        this.secondContext = secondContext;
    }

    public void setSecondListView(ListView secondListView) {
        this.secondListView = secondListView;
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

    public void removeStudent(Student student) {
        myDb.getStudentDAO().delete(student);
        reloadStudents();
    }

    public void editStudent(Student student) {
        myDb.getStudentDAO().update(student);
    }

    public GroupAdapter viewStudentGroups(Context context, int id){
        ArrayList<Group> groups = myDb.getStudentGroupDAO().selectAll(id);
        GroupAdapter adapter = new GroupAdapter(context, groups);
        return adapter;
    }

    public void loadStudentGroups(int id) {
        secondListView.setAdapter(null);
        secondListView.setAdapter(this.viewStudentGroups(mainContext, id));
    }
}
