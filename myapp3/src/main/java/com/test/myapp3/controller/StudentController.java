package com.test.myapp3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.test.myapp3.entity.Student;
import com.test.myapp3.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// Restful Http GET, POST, PUT, DELETE, PATCH
@RequestMapping("api/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long Id){
        Student student = studentService.getStudentById(Id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long Id){
        studentService.deleteStudent(Id);
        return new ResponseEntity<>("Student deleted", HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(
        @PathVariable("id") Long Id, @RequestBody Student student){
        student.setId(Id); 
        Student updatedStudent = studentService.updateStudent(student);     
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
}
