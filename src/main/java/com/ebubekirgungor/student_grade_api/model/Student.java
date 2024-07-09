package com.ebubekirgungor.student_grade_api.model;

import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Grade {
        private String code;
        private double value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "stdNumber", unique = true, nullable = false)
    private String stdNumber;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "grades", columnDefinition = "jsonb", nullable = false)
    private List<Grade> grades;
}
