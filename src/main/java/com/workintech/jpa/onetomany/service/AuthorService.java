package com.workintech.jpa.onetomany.service;

import com.workintech.jpa.onetomany.entity.Author;
import com.workintech.jpa.onetomany.entity.Book;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findById(int id);
    Author save(Author author);
    void delete(Author author);
}
