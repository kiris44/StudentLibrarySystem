package com.example.student_library_management_sys.service;

import com.example.student_library_management_sys.converter.BookConverter;
import com.example.student_library_management_sys.model.Author;
import com.example.student_library_management_sys.model.Book;
import com.example.student_library_management_sys.model.Card;
import com.example.student_library_management_sys.repository.AuthorRepository;
import com.example.student_library_management_sys.repository.BookRepository;
import com.example.student_library_management_sys.repository.CardRepository;
import com.example.student_library_management_sys.requestDTO.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CardRepository cardRepository;

    public String saveBook(BookRequestDto bookRequestDto){
        Book book = BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);

        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
        if(author!=null){
            book.setAuthor(author);
        }
        else {
            book.setAuthor(null);
        }

        Card card = cardRepository.findById(bookRequestDto.getCardId()).get();
        if(card!=null){
            book.setCard(card);
        }else{
            book.setCard(null);
        }

        bookRepository.save(book);
        return "Book saved successfully!!";
    }

    public Book getBookById(int id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        else{
            return null;
        }
    }

    public Book findBookByTitle(String title){
        Book book = bookRepository.findBookByTitle(title);
        return book;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> bookList = bookRepository.findBooksByGenre(genre);
        return bookList;
    }

    public List<Book> findBooksByPublisher(String publisher){
        List<Book> bookList = bookRepository.findBooksByPublisher(publisher);
        return bookList;
    }

    public List<Book> findBooksAssignedToCard(int c_id){
        List<Book> bookList = bookRepository.findBooksAssignedToCard(c_id);
        return bookList;
    }

    public List<Book> findBooksWrittenByAuthor(int a_id){
        List<Book> bookList = bookRepository.findBooksWrittenByAuthor(a_id);
        return bookList;
    }

    public String addAvailability(int id){
        Book book = getBookById(id);
        boolean temp = book.isAvailability();                   // debugging required
        if(temp == true){
            return "Book is already available!";
        }
        else{
            book.setAvailability(true);
            return "Availability added!";
        }
    }

    public String removeAvailability(int id){
        Book book = getBookById(id);
        boolean temp = book.isAvailability();                  // debugging required
        if(temp == true){
            book.setAvailability(false);
            return "Availability removed!";
        }
        else{
            return "Book already not available!";
        }
    }
}
