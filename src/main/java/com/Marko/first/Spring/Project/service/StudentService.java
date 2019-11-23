package com.Marko.first.Spring.Project.service;

import com.Marko.first.Spring.Project.database.StudentDao;
import com.Marko.first.Spring.Project.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(@Qualifier("dummyPostgres") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student getStudentById(UUID studentId) {
        return studentDao.selectStudent(studentId);

    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public void insertNewStudent(Student student) {
        UUID studentId;
        if (student.getId() == null) {
            studentId = UUID.randomUUID();
            student.setId(studentId);
        } else
            studentId = student.getId();
        studentDao.insertStudent(studentId, student);
    }

    public void deleteStudentById(UUID studentId) {
        studentDao.removeStudent(studentId);
    }

    public void updateStudent(UUID studentId, Student student) {
        studentDao.updateStudent(studentId, student);
    }
}
