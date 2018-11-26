package com.example.patryk.lab4.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.patryk.lab4.DataManager;
import com.example.patryk.lab4.R;
import com.example.patryk.lab4.model.EditActivity;
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
        final ViewGroup fparent = parent;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.student);
        textView.setText(student.toString());
        Button button = convertView.findViewById(R.id.editStudent);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SecondActivity.class);
                Bundle extras = new Bundle();
                extras.putInt("ID",student.getId());
                intent.putExtras(extras);
                getContext().startActivity(intent);
            }
        });

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Do you want to delete " + student.toString());
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        DataManager dataManager = DataManager.getInstance();
                        dataManager.removeStudent(student);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

                return true;
            }

        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditActivity.class);
                Bundle extras = new Bundle();
                extras.putInt("ID",student.getId());
                extras.putString("NAME",student.getName());
                extras.putString("LAST_NAME",student.getLastName());
                intent.putExtras(extras);
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }

}
