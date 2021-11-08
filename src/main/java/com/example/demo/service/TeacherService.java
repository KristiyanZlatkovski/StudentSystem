package com.example.demo.service;



import com.example.demo.model.Teacher;

import java.util.List;

public interface TeacherService {

    void save(Teacher teacher);
    List<Teacher> getAllTeachers();
}
