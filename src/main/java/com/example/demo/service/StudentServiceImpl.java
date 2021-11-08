package com.example.demo.service;



import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void save(Student student) {
         studentRepo.save(student);
    }
}
