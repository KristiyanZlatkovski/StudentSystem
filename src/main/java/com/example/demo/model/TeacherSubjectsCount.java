package com.example.demo.model;


import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "teacher_subjects_count")
public class TeacherSubjectsCount {

    @Id
    private String name;

    private int subjectsCount;

    public String getName() {
        return name;
    }

    public int getSubjectsCount() {
        return subjectsCount;
    }
}
