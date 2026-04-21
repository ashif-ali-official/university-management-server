package com.whoisashif.universitymanagementserver.professor.controller;

import com.whoisashif.universitymanagementserver.professor.dto.ProfessorRequest;
import com.whoisashif.universitymanagementserver.professor.entity.Professor;
import com.whoisashif.universitymanagementserver.professor.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    public Professor create(@RequestBody ProfessorRequest request) {
        return professorService.createProfessor(request);
    }

    @GetMapping
    public List<Professor> getAll() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public Professor getById(@PathVariable Long id) {
        return professorService.getProfessor(id);
    }

    @PutMapping("/{id}")
    public Professor update(@PathVariable Long id,
                            @RequestBody ProfessorRequest request) {
        return professorService.updateProfessor(id, request);
    }
}