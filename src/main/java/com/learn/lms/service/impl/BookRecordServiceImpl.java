package com.learn.lms.service.impl;

import com.learn.lms.dto.BookRecordDTO;
import com.learn.lms.entity.Book;
import com.learn.lms.entity.BookRecord;
import com.learn.lms.entity.User;
import com.learn.lms.repository.BookRecordRepository;
import com.learn.lms.repository.BookRepository;
import com.learn.lms.repository.UserRepository;
import com.learn.lms.service.BookRecordService;
import com.learn.lms.validation.BookRecordValidation;
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
public class BookRecordServiceImpl implements BookRecordService {

    private final BookRecordRepository bookRecordRepository;
    private final BookRecordValidation bookRecordValidation;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public ResponseEntity<?> saveBookRecord(BookRecordDTO dto) {
        try {
            if (bookRecordValidation.userExists(dto.getUserId()) && bookRecordValidation.bookExists(dto.getBookId())) {
                User userEntity = userRepository.findById(dto.getUserId()).get();
                dto.getBookId().stream()
                        .map(bookId -> bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book with ID " + bookId + " not found")))
                        .forEach(book -> saveEachRecord(userEntity, book));

                return ResponseEntity.ok("Book Record Saved Successfully !");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User or Book Id is not Valid !!");
            }
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save book records: " + exception.getMessage());
        }
    }

    private void saveEachRecord(User user, Book book) {
        BookRecord bookRecord = new BookRecord();
        bookRecord.setUser(user);
        bookRecord.setBook(book);
        bookRecordRepository.save(bookRecord);
    }

    @Override
    public ResponseEntity<?> deleteSavedBookRecord(BookRecordDTO dto) {
        try {
            if (bookRecordValidation.bookExists(dto.getBookId()) && bookRecordValidation.userExists(dto.getUserId())) {
                User userEntity = userRepository.findById(dto.getUserId()).get();
                dto.getBookId().stream()
                        .map(bookId -> bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book with ID " + bookId + " not found")))
                        .forEach(book -> deleteEachRecord(userEntity, book));
                return ResponseEntity.ok("Book Record Saved Successfully !");

            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User or Book Id is not Valid !!");
            }
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete book records: " + exception.getMessage());
        }
    }

    private void deleteEachRecord(User user, Book book) {
        BookRecord bookRecord = new BookRecord();
        bookRecord.setBook(book);
        bookRecord.setUser(user);
        try {
            bookRecordRepository.deleteByBookAndUserId(user,book);
        }catch (Exception exception){
            throw new RuntimeException("Error In Deleting Book Record !! class : BookRecordServiceImpl || method : deleteEachRecord()");
        }
    }
}
