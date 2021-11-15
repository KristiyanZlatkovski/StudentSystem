package com.example.demo.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Immutable
@Table(name = "teacher_subject_enlisted_count")
public class TeacherSubjectEnlistedCount {

    @Id
    private String subjectName;

    private String teacherName;

    private int enlistedStudentsCount;

    public String getTeacherName() {
        return teacherName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getEnlistedStudentsCount() {
        return enlistedStudentsCount;
    }
}