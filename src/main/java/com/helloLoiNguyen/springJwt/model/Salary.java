package com.helloLoiNguyen.springJwt.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="baseSalary")
    private double baseSalary;

    @Column(name="bonus")
    private double bonus;

    @Column(name = "overtimeSalary")
    private double overtimeSalary;

    @Column(name="deductions")
    private double deductions;

    @Column(name="salaryMonth")
    private Date salaryMonth;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
