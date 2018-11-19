package com.example.patryk.lab4.dao;

import com.example.patryk.lab4.interfaces.IStudentGroupDAO;
import com.example.patryk.lab4.tables.StudentGroupTable;

import java.util.ArrayList;

public class StudentGroupDAO implements IStudentGroupDAO {
    @Override
    public ArrayList<StudentGroupTable> selectAll() {
        return null;
    }

    @Override
    public StudentGroupTable selectById(int id) {
        return null;
    }

    @Override
    public int insert(StudentGroupTable studentGroupTable) {
        return 0;
    }

    @Override
    public boolean update(StudentGroupTable studentGroupTable) {
        return false;
    }

    @Override
    public boolean delete(StudentGroupTable studentGroupTable) {
        return false;
    }
}
