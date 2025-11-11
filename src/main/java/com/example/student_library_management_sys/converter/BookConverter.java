package com.example.student_library_management_sys.converter;

import com.example.student_library_management_sys.model.Book;
import com.example.student_library_management_sys.model.Student;
import com.example.student_library_management_sys.requestDTO.BookRequestDto;
import com.example.student_library_management_sys.requestDTO.StudentRequestDto;


public class BookConverter {

//    private boolean availability;
//    private String publisher;
//    private String title;
//    private int price;
//    private String genre;
//    private String language;
//    private int cardId;
//    private int authorId;

    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto){
        Book book = new Book();
        book.setAvailability(bookRequestDto.isAvailability());
        book.setPublisher(bookRequestDto.getPublisher());
        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setLanguage(bookRequestDto.getLanguage());

        return book;
    }
}
