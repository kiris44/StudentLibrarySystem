package com.example.student_library_management_sys.controller;

import com.example.student_library_management_sys.model.Student;
import com.example.student_library_management_sys.requestDTO.StudentRequestDto;
import com.example.student_library_management_sys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.addStudent(studentRequestDto);
        return response;
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
        Student student = studentService.findStudentById(id);
        return student;
    }

    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
        List<Student> studentList = studentService.findAllStudents();
        return studentList;
    }

    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.updateStudent(id,studentRequestDto);
        return response;
    }

    @GetMapping("/count")
    public String countStudent(){
        String response = studentService.countStudent();
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentByID(@PathVariable int id) {
        String response = studentService.deleteStudentById(id);
        return response;
    }

    //Pagination
    @GetMapping("/findPage")
    public List<Student> getStudentByPage(@RequestParam int pageNo,@RequestParam int pageSize){
        List<Student> studentList = studentService.getStudentUsingPage(pageNo,pageSize);
        return studentList;
    }

    @GetMapping("/findByDept")
    public List<Student> getStudentByDept(@RequestParam String dept){
        List<Student> student = studentService.getStudentByDept(dept);
        return student;
    }

    @GetMapping("/findByEmail")
    public List<Student> getStudentsByEmail(@RequestParam String email){
        List<Student> studentList = studentService.getStudentsByEmail(email);
        return studentList;
    }
}
