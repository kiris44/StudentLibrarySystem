package com.example.student_library_management_sys.repository;

import com.example.student_library_management_sys.model.Book;
import com.example.student_library_management_sys.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(nativeQuery = true, value ="select * from book where title = :title")
    public Book findBookByTitle(String title);

    @Query(nativeQuery = true, value ="select * from book where genre = :genre")
    public List<Book> findBooksByGenre(String genre);

    @Query(nativeQuery = true, value ="select * from book where publisher = :publisher")
    public List<Book> findBooksByPublisher(String publisher);

    @Query(nativeQuery = true, value ="select * from book where card_id = :c_id")
    public List<Book> findBooksAssignedToCard(int c_id);

    @Query(nativeQuery = true, value ="select * from book where author_id = :a_id")
    public List<Book> findBooksWrittenByAuthor(int a_id);
}
