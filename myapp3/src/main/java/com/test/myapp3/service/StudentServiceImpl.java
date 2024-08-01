package com.test.myapp3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.myapp3.entity.Student;
import com.test.myapp3.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(); 
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent = 
            studentRepository.findById(student.getId()).get();
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        Student updatedStudent = studentRepository.save(existingStudent);
        return updatedStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
