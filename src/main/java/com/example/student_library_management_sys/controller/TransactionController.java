package com.example.student_library_management_sys.controller;

import com.example.student_library_management_sys.model.Transaction;
import com.example.student_library_management_sys.requestDTO.CardRequestDto;
import com.example.student_library_management_sys.requestDTO.TransactionRequestDto;
import com.example.student_library_management_sys.service.CardService;
import com.example.student_library_management_sys.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction/apis")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        String response = transactionService.saveTransaction(transactionRequestDto);
        return response;
    }

    @GetMapping("/findTransaction/{id}")
    public Transaction findTransaction(@PathVariable int id){
        Transaction transaction =  transactionService.findTransaction(id);
        return transaction;
    }

    @GetMapping("/findTransactionsOnCard/{id}")
    public List<Transaction> findTransactionsFromCard(@PathVariable int c_id){
        List<Transaction> transactionList = transactionService.findTransactionsFromCard(c_id);
        return transactionList;
    }

    @GetMapping("/findTransactionsOnBook/{id}")
    public List<Transaction> findTransactionsOfBook(@PathVariable int b_id){
        List<Transaction> transactionList = transactionService.findTransactionsOfBook(b_id);
        return transactionList;
    }
}
