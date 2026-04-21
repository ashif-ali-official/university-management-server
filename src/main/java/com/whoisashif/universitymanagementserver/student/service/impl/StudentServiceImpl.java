package com.whoisashif.universitymanagementserver.student.service.impl;

import com.whoisashif.universitymanagementserver.student.dto.StudentRequest;
import com.whoisashif.universitymanagementserver.student.entity.Student;
import com.whoisashif.universitymanagementserver.student.repository.StudentRepository;
import com.whoisashif.universitymanagementserver.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(StudentRequest request) {

        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setDepartment(request.getDepartment());

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
    }
}