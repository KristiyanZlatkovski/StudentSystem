package com.example.demo.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "enlisted_students_per_subject")
public class StudentsPerSubject {
}
