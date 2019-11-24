package com.Marko.first.Spring.Project.database;

import com.Marko.first.Spring.Project.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("dummyPostgres")
public class StudentPostgresProvider implements StudentDao {

    private final Map<UUID, Student> database;

    public StudentPostgresProvider() {
        this.database = new HashMap<>();
        UUID studentId = UUID.randomUUID();
        database.put(studentId, new Student(studentId, "Jhon", "Doe", "noreply@JhonDoe.com", 12));
    }


    @Override
    public Student selectStudent(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void removeStudent(UUID studentId) {
        database.remove(studentId);
    }

    @Override
    public void updateStudent(UUID studentId, Student student) {
        database.put(studentId, student);
    }

    @Override
    public void insertStudent(UUID studentId, Student student) {
        database.put(studentId, student);
    }
}

