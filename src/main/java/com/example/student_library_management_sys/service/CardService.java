package com.example.student_library_management_sys.service;

import com.example.student_library_management_sys.converter.CardConverter;
import com.example.student_library_management_sys.enums.CARD_STATUS;
import com.example.student_library_management_sys.model.Book;
import com.example.student_library_management_sys.model.Card;
import com.example.student_library_management_sys.model.Transaction;
import com.example.student_library_management_sys.repository.CardRepository;
import com.example.student_library_management_sys.requestDTO.CardRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Card findCardById(int id){
        Optional<Card> card = cardRepository.findById(id);
        if(card.isPresent()){
            return card.get();
        }
        else{
            return null;
        }
    }

    public Card findCardDetailsById(int id){
        Optional<Card> card = cardRepository.findById(id);
        if(card.isPresent()){
            return card.get();
        }
        else{
            return null;
        }
    }

    public String countBooksOnCard(int id){
        Optional<Card> card = cardRepository.findById(id);
        List<Book> booklist = card.get().getBooksAssignedToCard();
        long count = booklist.toArray().length;
        if(count>0){
            return "No. of books per given car = " + count;
        }
        else{
            return "No books assigned to given card!";
        }
    }

    public List<Transaction> findTransactionsOnCard(int id){
        Optional<Card> card = cardRepository.findById(id);
        List<Transaction> transactions = card.get().getTransactionFromCard();
        if(!transactions.isEmpty()){
            return transactions;
        }
        else{
            return null;
        }
    }

    public String putInactiveCard(int id){
        Card card = findCardById(id);
        String ExpiryDate = card.getExpiry_date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(ExpiryDate, formatter);

        LocalDate todaysDate = LocalDate.now();
        if(todaysDate.isAfter(date)){
            card.setCard_status(CARD_STATUS.INACTIVE);
            return "Card is Inactive";
        }
        else{
            return "Card  is active!";
        }
    }

    public String putCardOnHold(int id){
        Card card  = findCardById(id);
        card.setCard_status(CARD_STATUS.HOLD);
        return "Your card has been put on hold";
    }

    public String removeCardFromHold(int id){
        Card card = findCardById(id);
        card.setCard_status(CARD_STATUS.ACTIVE);
        return "Your card has been removed from hold";
    }

    public List<Book> getBookList(int id){
        Card  card = findCardById(id);
        List<Book> bookList = card.getBooksAssignedToCard();
        if(!bookList.isEmpty()){
            return bookList;
        }
        else{
            return null;
        }
    }


}
