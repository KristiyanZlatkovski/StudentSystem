package com.example.demo.service;


import com.example.demo.model.Student;
import com.example.demo.model.StudentCredits;
import com.example.demo.model.StudentYear;

import java.util.List;

public interface StudentService {

    void save(Student student);
    List<Student> findAllStudents();
    List<StudentYear> findAllStudentsAndTheirYearInCollege();
    List<StudentCredits> findAllStudentsAndTheirTotalCredits();
}
