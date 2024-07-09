package com.ebubekirgungor.student_grade_api.dto;

import java.util.List;

import com.ebubekirgungor.student_grade_api.model.Student.Grade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String name;
    private String surname;
    private List<Grade> grades;
}
