package com.example.student_library_management_sys.service;

import com.example.student_library_management_sys.converter.StudentConverter;
import com.example.student_library_management_sys.enums.CARD_STATUS;
import com.example.student_library_management_sys.model.Card;
import com.example.student_library_management_sys.model.Student;
import com.example.student_library_management_sys.repository.StudentRepository;
import com.example.student_library_management_sys.requestDTO.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto){
        Student student = StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);

        Card card = new Card();
        card.setCard_status(CARD_STATUS.ACTIVE);
        card.setExpiry_date(LocalDate.now().plusYears(4).toString());
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);

        return "Student saved successfully!!";
    }

    public Student findStudentById(int id){
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        else{
            return null;
        }
    }

    public List<Student> findAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public String updateStudent(int id, StudentRequestDto studentRequestDto){
        Student student = findStudentById(id);

        if(student!=null){

            student.setName(studentRequestDto.getName());
            student.setEmail(studentRequestDto.getEmail());
            student.setMobile(studentRequestDto.getMobile());
            student.setDepartment(studentRequestDto.getDepartment());
            student.setDob(studentRequestDto.getDob());
            student.setGender(studentRequestDto.getGender());
            student.setAddress(studentRequestDto.getAddress());
            student.setSemester(studentRequestDto.getSemester());

            studentRepository.save(student);
            return "Student updated successfully!!";
        }
        else{
            return "Cannot make changes as student with id:" + id + " is absent";
        }
    }

    public String countStudent(){
        long count = studentRepository.count();
        return "Total number of students are: " + count;
    }

    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Student with id :" + id + " deleted!!";
    }

    public List<Student> getStudentUsingPage(int pageNo,int pageSize){     //page_size can be taken as a constant also
        List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNo,pageSize, Sort.by("name").ascending()   )).getContent();
        return studentList;
    }

    public List<Student> getStudentByDept(String dept){
        List<Student> student = studentRepository.getStudentByDept(dept);
        return student;
    }

    public List<Student> getStudentsByEmail(String email){
        List<Student> studentList = studentRepository.getStudentsByEmail(email);
        return studentList;
    }
}
