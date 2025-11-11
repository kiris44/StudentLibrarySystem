package com.example.student_library_management_sys.repository;

import com.example.student_library_management_sys.model.Student;
import com.example.student_library_management_sys.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(nativeQuery = true, value = "select * from transaction where card_id = :c_id")
    public List<Transaction> findTransactionsFromCard(int c_id);

    @Query(nativeQuery = true, value = "select * from transaction where book_id = :b_id")
    public List<Transaction> findTransactionsOfBook(int b_id);
}
