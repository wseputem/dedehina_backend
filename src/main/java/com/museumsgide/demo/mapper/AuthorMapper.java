package com.museumsgide.demo.mapper;

import com.museumsgide.demo.dto.AuthorDTO;
import com.museumsgide.demo.persistece.entity.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public Author creatAuthor(AuthorDTO authorDTO){
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        return author;
    }

    public AuthorDTO createAuthorDTO(Author author){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        return authorDTO;
    }
}
