package com.Marko.first.Spring.Project.resource;

import com.Marko.first.Spring.Project.model.Student;
import com.Marko.first.Spring.Project.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{StudentId}"
    )
    public Student getStudentBuId(@PathVariable("StudentId") UUID studentId) {
        return studentService.getStudentById(studentId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertStudent(@RequestBody Student student) {
        studentService.insertNewStudent(student);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{studentId}"
    )
    public void removeStudent(@PathVariable("studentId") UUID studentId) {
        studentService.deleteStudentById(studentId);

    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public void updateStudentById(@PathVariable("studentId") UUID studentId, @RequestBody Student student) {
        studentService.updateStudent(studentId, student);
    }

}