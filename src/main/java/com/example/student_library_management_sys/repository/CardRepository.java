package com.example.student_library_management_sys.repository;

import com.example.student_library_management_sys.model.Card;
import com.example.student_library_management_sys.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

}
