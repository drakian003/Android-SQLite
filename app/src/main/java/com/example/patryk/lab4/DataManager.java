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
    private ListView mainListView;
    private Context mainContext;


    public void setMainListView(ListView mainListView) {
        this.mainListView = mainListView;
    }

    public void setMainContext(Context mainContext) {
        this.mainContext = mainContext;
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

    public void reloadStudents(Context mainContext, ListView mainListView) {
        mainListView.setAdapter(null);
        mainListView.setAdapter(this.viewAllStudents(mainContext));
    }

    public void removeStudent(Student student) {
        myDb.getStudentDAO().delete(student);
        reloadStudents(this.mainContext, this.mainListView);
    }

    public void editStudent(Student student) {
        myDb.getStudentDAO().update(student);
    }

    public GroupAdapter viewStudentGroups(Context context, int id) {
        ArrayList<Group> groups = myDb.getStudentGroupDAO().selectAll(id);
        GroupAdapter adapter = new GroupAdapter(context, groups);
        return adapter;
    }

    public void loadStudentGroups(Context secondContext, ListView secondListView, int id) {
        secondListView.setAdapter(null);
        secondListView.setAdapter(this.viewStudentGroups(secondContext, id));
    }
}
