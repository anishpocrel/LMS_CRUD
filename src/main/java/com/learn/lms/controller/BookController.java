package com.learn.lms.controller;

import com.learn.lms.dto.BookDTO;
import com.learn.lms.service.BookService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anish
 * @project lms
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @PostMapping(path = "/add")
    public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO){
        return bookService.addBook(bookDTO);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<?> getAllBook(){
        return bookService.getBook();
    }

    @GetMapping(path = "/get")
    public ResponseEntity<?> getBook(@RequestParam Long id){
        return bookService.getBookById(id);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO){
        return bookService.updateBook(bookDTO);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteBook(@RequestParam Long id){
        return bookService.deleteBook(id);
    }

}







