package com.workintech.jpa.onetomany.controller;

import com.workintech.jpa.onetomany.entity.Author;
import com.workintech.jpa.onetomany.entity.Book;
import com.workintech.jpa.onetomany.entity.Category;
import com.workintech.jpa.onetomany.mapping.BookResponse;
import com.workintech.jpa.onetomany.service.AuthorService;
import com.workintech.jpa.onetomany.service.BookService;
import com.workintech.jpa.onetomany.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    private CategoryService categoryService;

    private AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService, AuthorService authorService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @GetMapping("/")
    public List<BookResponse> findAll() {
        List<Book> books = bookService.findAll();
        List<BookResponse> bookResponses = new ArrayList<>();
        for (Book book : books) {
            bookResponses.add(new BookResponse(book.getId(),
                    book.getName(), book.getCategory().getName()));
        }
        return bookResponses;
    }

    @GetMapping("/{id}")
    public BookResponse findById(@PathVariable int id) {
        Book book = bookService.findById(id);
        return new BookResponse(book.getId(), book.getName(), book.getCategory().getName());
    }

    @PostMapping("/{categoryId}")
    public BookResponse save(@RequestBody Book book, @PathVariable int categoryId) {
        Category category = categoryService.findById(categoryId);
        if (category != null) {
            book.setCategory(category);
            bookService.save(book);
            return new BookResponse(book.getId(), book.getName(), category.getName());
        }
        return null;
    }

    @PostMapping("saveByAuthor/{categoryId}/{authorId}")
    public BookResponse saveByAuthor(@RequestBody Book book,
                                     @PathVariable int categoryId,
                                     @PathVariable int authorId) {
        Category category = categoryService.findById(categoryId);
        if (category != null) {
            book.setCategory(category);
            Author author = authorService.findById(authorId);
            if (author != null) {
                book.setAuthor(author);
                Book savedBook = bookService.save(book);
                return new BookResponse(savedBook.getId(), savedBook.getName(),
                        savedBook.getCategory().getName(), savedBook.getAuthor().getFirstName(),
                        savedBook.getAuthor().getLastName());
            }
            return null;
        }
        return null;
    }

    @PutMapping("/{id}")
    public BookResponse update(@RequestBody Book book, @PathVariable int id) {
        Book foundBook = bookService.findById(id);
        if (foundBook != null) {
            book.setAuthor(foundBook.getAuthor());
            book.setCategory(foundBook.getCategory());
            book.setId(id);
            bookService.save(book);
            return new BookResponse(book.getId(), book.getName(), book.getCategory().getName());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public BookResponse delete(@PathVariable int id) {
        Book book = bookService.findById(id);
        if (book != null) {
            bookService.delete(book);
            return new BookResponse(book.getId(), book.getName(), book.getCategory().getName());
        }
        return null;
    }

}
