package com.safwan.tutionmanagement.service;

import com.safwan.tutionmanagement.modal.Student;
import com.safwan.tutionmanagement.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with this id: " +id));
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

}
