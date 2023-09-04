package com.workintech.jpa.onetomany.repository;

import com.workintech.jpa.onetomany.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
