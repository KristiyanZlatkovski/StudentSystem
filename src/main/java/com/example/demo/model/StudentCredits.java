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

        private int credits;

        public String getName() {
            return name;
        }

        public int getCredits() {
            return credits;
        }
    }