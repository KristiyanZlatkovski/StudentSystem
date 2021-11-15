package com.example.demo.service;



import com.example.demo.model.Student;
import com.example.demo.model.StudentCredits;
import com.example.demo.model.StudentYear;
import com.example.demo.repository.StudentCreditsRepo;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.StudentYearRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private StudentYearRepo studentYearRepo;
    @Autowired
    private StudentCreditsRepo studentCreditsRepo;




    @Override
    public void save(Student student) {
         studentRepo.save(student);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAllByOrderByNameAsc();
    }

    @Override
    public List<StudentYear> findAllStudentsAndTheirYearInCollege() {
        return studentYearRepo.findAll();
    }

    @Override
    public List<StudentCredits> findAllStudentsAndTheirTotalCredits() {
        return studentCreditsRepo.findAll();
    }
}
