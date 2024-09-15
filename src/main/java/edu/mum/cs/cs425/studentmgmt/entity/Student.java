package edu.mum.cs.cs425.studentmgmt.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private Double cgpa;

    @Column(nullable = false)
    private LocalDate enrollmentDate;

    @Column(nullable = false)
    private String isInternational;

    // Getters and Setters
    // Constructors
}
