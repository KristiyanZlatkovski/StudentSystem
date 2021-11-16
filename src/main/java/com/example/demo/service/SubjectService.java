package com.example.demo.service;


import com.example.demo.model.Student;
import com.example.demo.model.StudentsPerSubject;
import com.example.demo.model.Subject;

import java.util.List;

public interface SubjectService {

    void save(Subject subject);
    Subject findSubjectById(Long id);
    List<Subject> findAllSubjectsByStudent(Student student);
    List<Subject> findAllSubjects();
    List<StudentsPerSubject> findTop3SubjectsByStudentCount();
}
