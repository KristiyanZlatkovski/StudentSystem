package com.example.demo.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "enlisted_students_per_subject")
public class StudentsPerSubject {

    @Id
    private String subjectName;

    private int enlistedStudents;

    public String getSubjectName() {
        return subjectName;
    }

    public int getEnlistedStudents() {
        return enlistedStudents;
    }
}
