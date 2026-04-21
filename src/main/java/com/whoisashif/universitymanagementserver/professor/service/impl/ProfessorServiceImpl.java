package com.whoisashif.universitymanagementserver.professor.service.impl;

import com.whoisashif.universitymanagementserver.professor.dto.ProfessorRequest;
import com.whoisashif.universitymanagementserver.professor.entity.Professor;
import com.whoisashif.universitymanagementserver.professor.repository.ProfessorRepository;
import com.whoisashif.universitymanagementserver.professor.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public Professor createProfessor(ProfessorRequest request) {

        if (professorRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Professor already exists");
        }

        Professor professor = new Professor();
        professor.setName(request.getName());
        professor.setEmail(request.getEmail());
        professor.setDepartment(request.getDepartment());
        professor.setSpecialization(request.getSpecialization());

        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    @Override
    public Professor getProfessor(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor not found"));
    }

    @Override
    public Professor updateProfessor(Long id, ProfessorRequest request) {

        Professor professor = getProfessor(id);

        professor.setName(request.getName());
        professor.setDepartment(request.getDepartment());
        professor.setSpecialization(request.getSpecialization());

        return professorRepository.save(professor);
    }
}