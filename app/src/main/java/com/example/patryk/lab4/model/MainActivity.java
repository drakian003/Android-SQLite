package com.example.patryk.lab4.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.patryk.lab4.DataManager;
import com.example.patryk.lab4.DatabaseHelper;
import com.example.patryk.lab4.R;

public class MainActivity extends AppCompatActivity {

    private ListView list;

    private DataManager dataManager;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView);
        dataManager = DataManager.getInstance();
        databaseHelper = new DatabaseHelper(this, null, null, 1);
        dataManager.setMyDb(databaseHelper);
        dataManager.setMainListView(list);
        dataManager.setMainContext(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        dataManager.reloadStudents();
    }
}

