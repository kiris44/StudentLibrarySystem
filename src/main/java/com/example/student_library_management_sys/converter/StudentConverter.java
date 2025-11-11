package com.example.student_library_management_sys.converter;

import com.example.student_library_management_sys.model.Student;
import com.example.student_library_management_sys.requestDTO.StudentRequestDto;

public class StudentConverter {

    public static Student convertStudentRequestDtoIntoStudent(StudentRequestDto studentRequestDto){
        Student student = new Student();

        student.setName(studentRequestDto.getName());
        student.setEmail(studentRequestDto.getEmail());
        student.setMobile(studentRequestDto.getMobile());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setDob(studentRequestDto.getDob());
        student.setGender(studentRequestDto.getGender());
        student.setAddress(studentRequestDto.getAddress());
        student.setSemester(studentRequestDto.getSemester());

        return student;
    }

}
