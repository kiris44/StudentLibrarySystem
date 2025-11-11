package com.example.student_library_management_sys.controller;

import com.example.student_library_management_sys.model.Book;
import com.example.student_library_management_sys.requestDTO.BookRequestDto;
import com.example.student_library_management_sys.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book/apis")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/save")
    public String saveBook(@RequestBody BookRequestDto bookRequestDto){
        String response = bookService.saveBook(bookRequestDto);
        return response;
    }

    @GetMapping("/findBook/{id}")
    public Book getBookById(@PathVariable int id){
        Book book = bookService.getBookById(id);
        return book;
    }

    @GetMapping("/findBookByTitle")
    public Book findBookByTitle(@RequestParam String title){
        Book book = bookService.findBookByTitle(title);
        return book;
    }

    @GetMapping("/findBooksByGenre")
    public List<Book> findBooksByGenre(@RequestParam String genre){
        List<Book> bookList = bookService.findBooksByGenre(genre);
        return bookList;
    }

    @PutMapping("/addAvailability/{id}")
    public String addAvailability(@PathVariable int id){         // debug
        String response = bookService.addAvailability(id);
        return response;
    }

    @PutMapping("/removeAvailability/{id}")
    public String removeAvailability(@PathVariable int id){
        String response = bookService.removeAvailability(id);    // debug
        return response;
    }

    @GetMapping("/findBooksByPublisher")
    public List<Book> findBooksByPublisher(@RequestParam String publisher){
        List<Book> bookList = bookService.findBooksByPublisher(publisher);
        return bookList;
    }

    @GetMapping("/findBooksAssignedToCard")
    public List<Book> findBooksAssignedToCard(@RequestParam int c_id){
        List<Book> bookList = bookService.findBooksAssignedToCard(c_id);
        return bookList;
    }

    @GetMapping("/findBooksWrittenByAuthor")
    public List<Book> findBooksWrittenByAuthor(@RequestParam int a_id){
        List<Book> bookList = bookService.findBooksWrittenByAuthor(a_id);
        return bookList;
    }
}
