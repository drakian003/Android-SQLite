package com.example.patryk.lab4.model;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.patryk.lab4.DataManager;
import com.example.patryk.lab4.DatabaseHelper;
import com.example.patryk.lab4.R;
import com.example.patryk.lab4.StudentAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView list ;

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        list = findViewById(R.id.listView);
        dataManager = new DataManager(this);

        list.setAdapter(dataManager.viewAllStudents(this));
}
}
