package com.example.student_library_management_sys.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="publisher", nullable = false)
    private String publisher;

    @Column(name="title", nullable = false,  unique = true)
    private String title;

    @Column(name="genre", nullable = false)
    private String genre;

    @Column(name="language", nullable = false)
    private String language;

    @Column(name="availability", nullable = false)
    private boolean availability;

    // column of book is added to author table
    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private Author author;

    // column of book is added to card table
    @JsonBackReference
    @JoinColumn
    @ManyToOne
    private  Card card;

    // column of a transaction list is added to book table
    @JsonManagedReference
    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionsOfBook;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Transaction> getTransactionsOfBook() {
        return transactionsOfBook;
    }

    public void setTransactionsOfBook(List<Transaction> transactionsOfBook) {
        this.transactionsOfBook = transactionsOfBook;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
