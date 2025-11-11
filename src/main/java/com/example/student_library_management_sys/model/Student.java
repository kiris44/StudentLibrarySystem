package com.example.student_library_management_sys.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
// imports all important annotation builders
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity                    //assigns the class as a database
@Table(name = "student")   //creates a table in database

public class Student {

    @Id                    //declares it as primary key
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // database itself generates a unique ID during each insertion operation
    // commonly used with databases like MySQL and PostgreSQL
    private int id;
    @Column(name="email", nullable = false, unique = true)
    private String email;
    @Column(name="name", nullable = false)
    private String name;
    @Column(name="mobile", nullable = false)
    private String mobile;
    @Column(name="department", nullable = false)
    private String department;
    @Column(name="semester", nullable = false)
    private int semester;
    @Column(name="gender", nullable = false)
    private String gender;
    @Column(name="dob", nullable = false)
    private String dob;
    @Column(name="address", nullable = false)
    private String address;


    //card column addition
    @JsonManagedReference          //used to prevent looping of data in apis
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
