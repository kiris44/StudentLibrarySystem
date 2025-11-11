package com.example.student_library_management_sys.service;

import com.example.student_library_management_sys.converter.AuthorConverter;
import com.example.student_library_management_sys.model.Author;
import com.example.student_library_management_sys.repository.AuthorRepository;
import com.example.student_library_management_sys.requestDTO.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String saveAuthor(AuthorRequestDto authorRequestDto){
        Author author = AuthorConverter.convertAuthorRequestDtoIntoAuthor(authorRequestDto);
        authorRepository.save(author);
        return " Author saved successfully!!";
    }
    
    public Author findAuthor(int id){
        Optional<Author> author = authorRepository.findById(id);
        if(author.isPresent()){
            return author.get();
        }
        else{
            return null;
        }
    }

    public Author findAuthorByEmail(String email){
        Author author = authorRepository.findAuthorByEmail(email);
        return author;
    }
}
