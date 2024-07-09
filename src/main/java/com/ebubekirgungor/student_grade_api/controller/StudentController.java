package com.ebubekirgungor.student_grade_api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebubekirgungor.student_grade_api.exception.StudentAlreadyExistsException;
import com.ebubekirgungor.student_grade_api.model.Student;
import com.ebubekirgungor.student_grade_api.model.Student.Grade;
import com.ebubekirgungor.student_grade_api.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public Student createStudent(@RequestBody Student newStudent) {

        var existingStudent = studentRepository.findByStdNumber(newStudent.getStdNumber());

        if (existingStudent != null) {
            throw new StudentAlreadyExistsException("Student with given number is already exists");
        }

        Map<String, List<Double>> gradesMap = new HashMap<>();

        for (Grade grade : newStudent.getGrades()) {
            List<Double> cloneGrade = gradesMap.get(grade.getCode());

            if (cloneGrade != null) {
                cloneGrade.add(grade.getValue());
                gradesMap.put(grade.getCode(), cloneGrade);
            } else {
                List<Double> newValueList = new ArrayList<>();
                newValueList.add(grade.getValue());
                gradesMap.put(grade.getCode(), newValueList);
            }
        }

        List<Grade> grades = new ArrayList<>();

        for (String gradeCode : gradesMap.keySet()) {
            Grade newGrade = new Grade();
            newGrade.setCode(gradeCode);
            newGrade.setValue(gradesMap.get(gradeCode).stream().mapToDouble(d -> d).average().orElse(0.0));
            grades.add(newGrade);
        }

        newStudent.setGrades(grades);

        return studentRepository.save(newStudent);
    }
}
