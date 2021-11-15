package com.example.demo.service;




import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherSubjectsCount;
import com.example.demo.repository.TeacherRepo;
import com.example.demo.repository.TeacherSubjectsCountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepo teacherRepo;
    @Autowired
    private TeacherSubjectsCountRepo teacherSubjectsCountRepo;

    @Override
    public void save(Teacher teacher) {
         teacherRepo.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();

    }

    @Override
    public List<TeacherSubjectsCount> getAllTeachersAndSubjectsCount() {
        return teacherSubjectsCountRepo.findAll();
    }
}
