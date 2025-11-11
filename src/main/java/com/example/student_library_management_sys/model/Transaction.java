package com.example.student_library_management_sys.model;

import com.example.student_library_management_sys.enums.TRANSACTION_TYPE;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transactionDate", nullable = false)
    @CreationTimestamp
    private Date transactionDate;

    @Column(name = "dueDate", nullable = false)
    private Date dueDate;

    @Column(name = "transactionType", nullable = false)
    @Enumerated(value = EnumType.STRING )
    private TRANSACTION_TYPE transactionType;

    // addition of a column of list of transaction to card table
    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Card card;

    // addition of a column of list of transaction to book table
    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Book book;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dyeDate) {
        this.dueDate = dyeDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TRANSACTION_TYPE getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TRANSACTION_TYPE transactionType) {
        this.transactionType = transactionType;
    }
}
