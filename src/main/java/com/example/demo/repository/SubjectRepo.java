package com.example.demo.repository;



import com.example.demo.model.Student;
import com.example.demo.model.Subject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
List<Subject> findAllByStudents(Student student);
    List<Subject> findAllByOrderByNameAsc();
}