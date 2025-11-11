package com.example.student_library_management_sys.repository;

import com.example.student_library_management_sys.model.Author;
import com.example.student_library_management_sys.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends JpaRepository<Author, Integer> {

    @Query(nativeQuery = true, value = "select * from author where email = :email")
    public Author findAuthorByEmail(String email);
}
