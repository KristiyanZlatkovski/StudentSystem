package com.example.demo.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
    @Immutable
    @Table(name = "student_and_course")
    public class StudentYear {

        @Id
        private String name;

        private int yearInCollege;

        public String getName() {
            return name;
        }

        public int getYearInCollege() {
            return yearInCollege;
        }
    }