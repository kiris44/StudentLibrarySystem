package com.example.student_library_management_sys.controller;

import com.example.student_library_management_sys.model.Author;
import com.example.student_library_management_sys.requestDTO.AuthorRequestDto;
import com.example.student_library_management_sys.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author/apis")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        String response = authorService.saveAuthor(authorRequestDto);
        return response;
    }

    @GetMapping("/findAuthor/{id}")
    public Author findAuthor(@PathVariable int id){
        Author author = authorService.findAuthor(id);
        return author;
    }

    @GetMapping("/findAuthorByEmail")
    public Author findAuthorByEmail(@RequestParam String email){
        Author author = authorService.findAuthorByEmail(email);
        return author;
    }
}
