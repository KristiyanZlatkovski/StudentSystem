package com.example.demo.repository;



import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {

}