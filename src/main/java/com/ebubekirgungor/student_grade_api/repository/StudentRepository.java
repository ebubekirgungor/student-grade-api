package com.ebubekirgungor.student_grade_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebubekirgungor.student_grade_api.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStdNumber(String stdNumber);
}
