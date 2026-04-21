package com.whoisashif.universitymanagementserver.student.service;

import com.whoisashif.universitymanagementserver.student.dto.StudentRequest;
import com.whoisashif.universitymanagementserver.student.entity.Student;

import java.util.List;

public interface StudentService {

    public Student createStudent(StudentRequest request);
    public List<Student> getAllStudents();
    public Student getStudent(Long id);

}
