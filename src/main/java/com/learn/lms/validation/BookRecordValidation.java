package com.learn.lms.validation;

import com.learn.lms.repository.BookRecordRepository;
import com.learn.lms.repository.BookRepository;
import com.learn.lms.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author anish
 * @project lms
 */
@Component
@RequiredArgsConstructor
public class BookRecordValidation {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public boolean userExists(Long userId){
        return userRepository.existsById(userId);
    }

    public boolean bookExists(List<Long> bookIds){
        return bookIds.stream()
                .allMatch(bookId -> bookRepository.existsById(bookId));
    }
}
