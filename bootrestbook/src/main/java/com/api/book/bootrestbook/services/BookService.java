package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBook() {
        List<Book> list = (List<Book>) bookRepository.findAll();
        return list;
    }

    // single book by id
    public Book getBookById(int bookId) {
        Book book = null;
        try {
            book = this.bookRepository.findById(bookId);
            return book;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public Book addBook(Book b) {

        Book result = this.bookRepository.save(b);
        return result;
    }

    public void deleteBook(int id) {
        this.bookRepository.deleteById(id);
    }

    // update book
    public void updateBook(Book book, int id) {
        /*
         * list = list.stream().map(b -> {
         * if (b.getId() == id) {
         * b.setTitle(book.getTitle());
         * b.setAuthor(book.getAuthor());
         * }
         * 
         * 
         * return b;
         * }).collect(Collectors.toList());
         */
        book.setId(id);
        this.bookRepository.save(book);
    }
}
