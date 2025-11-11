package com.example.student_library_management_sys.converter;

import com.example.student_library_management_sys.enums.TRANSACTION_TYPE;
import com.example.student_library_management_sys.model.Book;
import com.example.student_library_management_sys.model.Card;
import com.example.student_library_management_sys.model.Student;
import com.example.student_library_management_sys.model.Transaction;
import com.example.student_library_management_sys.requestDTO.StudentRequestDto;
import com.example.student_library_management_sys.requestDTO.TransactionRequestDto;

import java.util.Date;

public class TransactionConverter {

    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){

//        private Date dueDate;
//        private TRANSACTION_TYPE transactionType;
//        private Book bookId;
//        private Card cardId;

        Transaction transaction = new Transaction();

        transaction.setDueDate(transactionRequestDto.getDueDate());
        transaction.setTransactionType(transactionRequestDto.getTransactionType());

        return transaction;
    }
}
