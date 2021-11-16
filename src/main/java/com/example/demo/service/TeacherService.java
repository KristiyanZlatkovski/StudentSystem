package com.example.demo.service;



import com.example.demo.model.Teacher;
import com.example.demo.model.TeacherSubjectsCount;
import com.example.demo.model.TopTeachers;

import java.util.List;

public interface TeacherService {

    void save(Teacher teacher);
    List<Teacher> getAllTeachers();
    List<TeacherSubjectsCount> getAllTeachersAndSubjectsCount();
    List<TopTeachers> getTopThreeTeachersByStudentCount();
}
