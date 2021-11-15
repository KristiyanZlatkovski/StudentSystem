package com.example.demo.service;



import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherSubjectsCount;

import java.util.List;

public interface TeacherService {

    void save(Teacher teacher);
    List<Teacher> getAllTeachers();
    List<TeacherSubjectsCount> getAllTeachersAndSubjectsCount();
}
