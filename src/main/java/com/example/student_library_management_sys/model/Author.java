package com.example.student_library_management_sys.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="Author")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "rating", nullable = false)
    private double rating;

    // column of list of author is assigned to author table
    @JsonManagedReference
    @OneToMany(mappedBy = "author")
    private List<Book> booksWrittenByAuthor;

    public List<Book> getBooksWrittenByAuthor() {
        return booksWrittenByAuthor;
    }

    public void setBooksWrittenByAuthor(List<Book> booksWrittenByAuthor) {
        this.booksWrittenByAuthor = booksWrittenByAuthor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
