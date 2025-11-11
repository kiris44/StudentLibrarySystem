package com.example.student_library_management_sys.controller;

import com.example.student_library_management_sys.model.Book;
import com.example.student_library_management_sys.model.Card;
import com.example.student_library_management_sys.model.Transaction;
import com.example.student_library_management_sys.requestDTO.CardRequestDto;
import com.example.student_library_management_sys.requestDTO.StudentRequestDto;
import com.example.student_library_management_sys.service.CardService;
import com.example.student_library_management_sys.service.StudentService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card/apis")
public class CardController {

    @Autowired
    CardService cardService;

    @GetMapping("/findCard/{id}")
    public Card findCardDetailsById(@PathVariable int id){
        Card card = cardService.findCardDetailsById(id);
        return card;
    }


    @GetMapping("/countBooksOnCard/{id}")
    public String countBooksOnCard(@PathVariable int id){
        String response = cardService.countBooksOnCard(id);
        return response;
    }

    @GetMapping("/countTransactionsOnCard/{id}")
    public List<Transaction> findTransactionsOnCard(@PathVariable int id){
        List<Transaction> transactions = cardService.findTransactionsOnCard(id);
        return transactions;
    }

    //debugging required
    @PutMapping("/cardStatus/{id}")
    public String putInactiveCard(@PathVariable int id){
        String response = cardService.putInactiveCard(id);
        return response;
    }

    @PutMapping("/putCardHold/{id}")
    public String putCardOnHold(@PathVariable int id){
        String response = cardService.putCardOnHold(id);
        return response;
    }

    @PutMapping("/removeCardHold/{id}")
    public String removeCardFromHold(@PathVariable int id){
        String response = cardService.removeCardFromHold(id);
        return response;
    }

    @GetMapping("/getBookList/{id}")
    public List<Book> getBookList(int id){
        List<Book> bookList = cardService.getBookList(id);
        return bookList;
    }

}