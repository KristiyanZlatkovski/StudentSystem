package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String title;


    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title==null || title.trim().isEmpty()) {throw new IllegalArgumentException("invalid title");}
        this.title = title;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        if(subjects.isEmpty()|| Objects.isNull(subjects)) {throw new IllegalArgumentException("subjects cant be empty");}
        this.subjects = subjects;
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