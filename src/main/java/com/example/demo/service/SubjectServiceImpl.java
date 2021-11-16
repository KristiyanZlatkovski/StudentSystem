package com.example.demo.service;




import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public void save(Subject subject) {
         subjectRepo.save(subject);
    }

    @Override
    public Subject findSubjectById(Long id) {
        return subjectRepo.findById(id).get();
    }

    @Override
    public List<Subject> findAllSubjectsByStudent(Student student) {
        return subjectRepo.findAllByStudents(student);
    }

    @Override
    public List<Subject> findAllSubjects() {
        return subjectRepo.findAll();
    }
}
