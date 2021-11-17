package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private byte course;

    @ManyToMany(mappedBy = "students")
    private Set<Subject> subjects;

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        if(subjects.isEmpty()|| Objects.isNull(subjects)) {throw new IllegalArgumentException("subjects cant be empty");}
        this.subjects = subjects;
    }

    public byte getCourse() {
        return course;
    }

    public void setCourse(byte course) {
        if(course<=0) {throw new IllegalArgumentException("Student year in college can't be 0 or less");}
        this.course = course;
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
        if(name==null || name.trim().isEmpty()) {throw new IllegalArgumentException("name is invalid");}
        this.name = name;
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.getStudents().add(this);
    }

    public void removeSubject(Subject subject) {
        this.subjects.remove(subject);
        subject.getStudents().remove(this);
    }



}