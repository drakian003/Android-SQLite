package com.example.patryk.lab4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.patryk.lab4.model.SecondActivity;
import com.example.patryk.lab4.tables.Group;
import com.example.patryk.lab4.tables.Student;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(Context context, ArrayList<Student> students) {
        super(context, 0, students);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Student student = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.student);
        textView.setText(student.toString());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SecondActivity.class);
                ArrayList<Group> message = student.getGroups();
                intent.putExtra("grupy", message);
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
