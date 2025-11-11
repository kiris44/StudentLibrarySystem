package com.example.student_library_management_sys.converter;

import com.example.student_library_management_sys.model.Author;
import com.example.student_library_management_sys.model.Student;
import com.example.student_library_management_sys.requestDTO.AuthorRequestDto;
import com.example.student_library_management_sys.requestDTO.StudentRequestDto;

public class AuthorConverter {

    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto){

//        private String name;
//        private String email;
//        private String gender;
//        private String country;
//        private double rating;

        Author author = new Author();

        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setGender(authorRequestDto.getGender());
        author.setCountry(authorRequestDto.getCountry());
        author.setRating(authorRequestDto.getRating());

        return author;
    }
}
