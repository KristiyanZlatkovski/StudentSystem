package com.example.demo.service;




import com.example.demo.model.Subject;
import com.example.demo.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public void save(Subject subject) {
         subjectRepo.save(subject);
    }
}
