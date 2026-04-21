package com.whoisashif.universitymanagementserver.professor.service;

import com.whoisashif.universitymanagementserver.professor.dto.ProfessorRequest;
import com.whoisashif.universitymanagementserver.professor.entity.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {

    public Professor createProfessor(ProfessorRequest request);
    public List<Professor> getAllProfessors();
    public Professor getProfessor(Long id);
    public Professor updateProfessor(Long id, ProfessorRequest request);

}
