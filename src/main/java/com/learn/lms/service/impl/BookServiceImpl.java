package com.learn.lms.service.impl;

import com.learn.lms.dto.BookDTO;
import com.learn.lms.entity.Book;
import com.learn.lms.mapper.BookMapper;
import com.learn.lms.repository.BookRepository;
import com.learn.lms.service.BookService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author anish
 * @project lms
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public ResponseEntity<?> addBook(BookDTO bookDTO) {
        try {
            Book save = bookRepository.save(BookMapper.toEntity(bookDTO));
            return ResponseEntity.ok(save.getId());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save book !! || class : BookServiceImpl || method addBook()." + exception.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getBook() {
        try {
            return ResponseEntity.ok(bookRepository.findAll());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve books !! || class : BookServiceImpl || method getBook()." + exception.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getBookById(Long id) {
        try {
            Optional<Book> book = bookRepository.findById(id);
            if (book.isPresent()) {
                return ResponseEntity.ok(book.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found with id :" + id + " || class : BookServiceImpl || method getBookById().");
            }
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve book !! || class : BookServiceImpl || method getBookById()." + exception.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updateBook(BookDTO bookDTO) {
        try {
            if (!bookRepository.existsById(bookDTO.getId())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found with id :" + bookDTO.getId() + " || class : BookServiceImpl || method updateBook().");
            }
            Book book = bookRepository.findById(bookDTO.getId()).get();
            book.setAuthor(bookDTO.getAuthor());
            book.setName(bookDTO.getName());
            book.setIsbnNumber(bookDTO.getIsbnNumber());
            bookRepository.save(book);
            return ResponseEntity.ok("Book with id : " + bookDTO.getId() + " Updated Successfully !!");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update book !! || class : BookServiceImpl || method getBookById()." + exception.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> deleteBook(Long id) {
        try {
            if (!bookRepository.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found with id :" + id + " || class : BookServiceImpl || method deleteBook().");
            }
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Book with id : " + id + " Deleted Successfully !!");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete book !! || class : BookServiceImpl || method getBookById()." + exception.getMessage());
        }
    }
}
