package com.example.student_library_management_sys.model;

import com.example.student_library_management_sys.enums.CARD_STATUS;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="created_date", nullable = false)
    @CreationTimestamp
    private Date created_date;

    @Column(name="updated_date")
    @UpdateTimestamp
    private Date updated_date;

    @Column(name="expiry_date", nullable = false)
    private String expiry_date;

    @Column(name="card_status", nullable = false)
    private CARD_STATUS card_status;


    // addition of a column 'card' to student table
    @JsonBackReference
    @JoinColumn
    @OneToOne
    private Student student;    //foreign key connection

    // a column of list of books is added to card table
    @JsonManagedReference
    @OneToMany(mappedBy = "card")
    private List<Book> booksAssignedToCard;

    // a column of list of transaction is added to card table
    @JsonManagedReference
    @OneToMany(mappedBy = "card")
    private List<Transaction> transactionFromCard;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBooksAssignedToCard() {
        return booksAssignedToCard;
    }

    public void setBooksAssignedToCard(List<Book> booksAssignedToCard) {
        this.booksAssignedToCard = booksAssignedToCard;
    }

    public List<Transaction> getTransactionFromCard() {
        return transactionFromCard;
    }

    public void setTransactionFromCard(List<Transaction> transactionFromCard) {
        this.transactionFromCard = transactionFromCard;
    }

    public CARD_STATUS getCard_status() {
        return card_status;
    }

    public void setCard_status(CARD_STATUS card_status) {
        this.card_status = card_status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_data) {
        this.updated_date = updated_data;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
}
