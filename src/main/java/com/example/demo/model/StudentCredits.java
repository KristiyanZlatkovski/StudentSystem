package com.example.demo.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
    @Immutable
    @Table(name = "students_and_credits")
    public class StudentCredits {

        @Id
        private String name;

        private int totalCredits;

        public String getName() {
            return name;
        }

        public int getTotalCredits() {
            return totalCredits;
        }
    }