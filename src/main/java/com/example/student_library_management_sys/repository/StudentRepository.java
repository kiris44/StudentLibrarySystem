package com.example.student_library_management_sys.repository;

import com.example.student_library_management_sys.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(nativeQuery = true, value = "select * from student where department= :dept")
    public List<Student> getStudentByDept(String dept);

    @Query(nativeQuery = true, value = "select * from student where email= :inputEmail")
    public List<Student> getStudentsByEmail(String inputEmail);
}
