package com.example.student_library_management_sys.requestDTO;

import com.example.student_library_management_sys.enums.TRANSACTION_TYPE;
import com.example.student_library_management_sys.model.Book;
import com.example.student_library_management_sys.model.Card;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
import java.util.Date;

public class TransactionRequestDto {

    private Date dueDate;
    private TRANSACTION_TYPE transactionType;
    private int bookId;
    private int cardId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TRANSACTION_TYPE getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TRANSACTION_TYPE transactionType) {
        this.transactionType = transactionType;
    }
}
