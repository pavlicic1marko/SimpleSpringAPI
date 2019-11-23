package com.Marko.first.Spring.Project.database;


import com.Marko.first.Spring.Project.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {

    Student selectStudent(UUID studentId);

    List<Student> selectAllStudents();

    void removeStudent(UUID studentId);

    void updateStudent(UUID studentId, Student student);

    void insertStudent(UUID studentId, Student student);
}
