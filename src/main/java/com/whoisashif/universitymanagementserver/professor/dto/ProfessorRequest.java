package com.whoisashif.universitymanagementserver.professor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRequest {

    private String name;
    private String email;
    private String department;
    private String specialization;

}