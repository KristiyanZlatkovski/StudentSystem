package com.example.demo.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "teachers_ranking_by_students_count")
public class TopTeachers {

    @Id
    private String name;

    private int totalStudents;

    public String getName() {
        return name;
    }

    public int getTotalStudents() {
        return totalStudents;
    }
}
