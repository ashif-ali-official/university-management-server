package com.whoisashif.universitymanagementserver.student.controller;

import com.whoisashif.universitymanagementserver.student.dto.StudentRequest;
import com.whoisashif.universitymanagementserver.student.entity.Student;
import com.whoisashif.universitymanagementserver.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student create(@RequestBody StudentRequest request) {
        return studentService.createStudent(request);
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getStudent(id);
    }
}