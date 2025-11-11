package com.example.student_library_management_sys.service;

import com.example.student_library_management_sys.converter.TransactionConverter;
import com.example.student_library_management_sys.model.Book;
import com.example.student_library_management_sys.model.Card;
import com.example.student_library_management_sys.model.Transaction;
import com.example.student_library_management_sys.repository.BookRepository;
import com.example.student_library_management_sys.repository.CardRepository;
import com.example.student_library_management_sys.repository.TransactionRepository;
import com.example.student_library_management_sys.requestDTO.TransactionRequestDto;
import org.hibernate.internal.TransactionManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String saveTransaction(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = TransactionConverter.convertTransactionRequestDtoIntoTransaction(transactionRequestDto);

        Book book = bookRepository.findById(transactionRequestDto.getBookId()).get();
        if(book!=null){
            transaction.setBook(book);
        }
        else{
            transaction.setBook(null);
        }

        Card card = cardRepository.findById(transactionRequestDto.getCardId()).get();
        if(card!=null){
            transaction.setCard(card);
        }
        else{
            transaction.setCard(null);
        }

        transaction.setDueDate(Date.valueOf(LocalDate.now().plusMonths(6)));

        transactionRepository.save(transaction);
        return "Transaction saved successfully!!";
    }

    public Transaction findTransaction(int id){
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isPresent()){
            return transaction.get();
        }
        else{
            return null;
        }
    }

    public List<Transaction> findTransactionsFromCard(int c_id){
        List<Transaction> transactionList = transactionRepository.findTransactionsFromCard(c_id);
        return transactionList;
    }

    public List<Transaction> findTransactionsOfBook(int b_id){
        List<Transaction> transactionList = transactionRepository.findTransactionsOfBook(b_id);
        return transactionList;
    }
}
