package com.example.student_library_management_sys.requestDTO;

import com.example.student_library_management_sys.model.Book;
import com.example.student_library_management_sys.model.Card;
import jakarta.persistence.Column;

import java.util.Date;

public class StudentRequestDto {

    private String email;
    private String name;
    private String mobile;
    private String department;
    private int semester;
    private String gender;
    private String dob;
    private String address;

//    "email":"krishsharma55@gmail.com",
//            "name":"krish sharma",
//            "mobile":"+91 98765xxxxx",
//            "department":"CSE",
//            "semester":"Third",
//            "gender":"Male",
//            "dob":"2006-06-21",
//            "address":"site-2,h-no-06,vikaspuri"


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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
