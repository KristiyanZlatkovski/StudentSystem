package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int credits;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    @ManyToMany
    private Set<Student> students;

    public Teacher getTeacher() {
        return teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        if(students.isEmpty()|| Objects.isNull(students)) {throw new IllegalArgumentException("students cant be empty");}
        this.students = students;
    }

    public void setTeacher(Teacher teacher) {
        if(Objects.isNull(students)) {throw new IllegalArgumentException("teacher cant be empty");}
        this.teacher = teacher;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if(credits<=0) {throw new IllegalArgumentException("Student year in college can't be 0 or less");}
        this.credits = credits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id<=0) {throw new IllegalArgumentException("Id can't be 0 or less");}
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()) {throw new IllegalArgumentException("invalid name");}
        this.name = name;
    }
}
