package com.learn.lms.service;

import com.learn.lms.dto.BookDTO;
import org.springframework.http.ResponseEntity;

/**
 * @author anish
 * @project lms
 */
public interface BookService {
    ResponseEntity<?> addBook(BookDTO bookDTO);

    ResponseEntity<?> getBook();

    ResponseEntity<?> getBookById(Long id);

    ResponseEntity<?> updateBook(BookDTO bookDTO);

    ResponseEntity<?> deleteBook(Long id);
}
