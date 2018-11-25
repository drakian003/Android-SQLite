package com.example.patryk.lab4.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.patryk.lab4.DataManager;
import com.example.patryk.lab4.R;
import com.example.patryk.lab4.tables.Student;

public class EditActivity extends AppCompatActivity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        final int student_id = extras.getInt("ID");
        final String student_name = extras.getString("NAME");
        final String student_last_name = extras.getString("LAST_NAME");

        final EditText name = findViewById(R.id.nameedit);
        name.setText(student_name);
        final EditText lname = findViewById(R.id.lnameedit);
        lname.setText(student_last_name);



        Button cancel = findViewById(R.id.cancelbutton);
        Button accept = findViewById(R.id.acceptbutton);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataManager dataManager = DataManager.getInstance();
                String changed_name = name.getText()+"";
                String changed_lname = lname.getText()+"";
                if (changed_name.matches("") || changed_lname.matches("") ) {
                    Toast toast = Toast.makeText(context, "Empty name or last name", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    dataManager.editStudent(new Student(student_id,changed_name,changed_lname));
                    Intent intent = new Intent(EditActivity.this, MainActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
