package com.example.patryk.lab4.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.patryk.lab4.DataManager;
import com.example.patryk.lab4.R;

public class SecondActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int student_id = extras.getInt("ID");
        list = findViewById(R.id.listView2);
        DataManager dataManager = DataManager.getInstance();
        dataManager.setSecondContext(this);
        dataManager.setSecondListView(list);
        dataManager.loadStudentGroups(student_id);
    }
}
