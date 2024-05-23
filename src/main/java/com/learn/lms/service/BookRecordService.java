package com.learn.lms.service;

import com.learn.lms.dto.BookRecordDTO;
import org.springframework.http.ResponseEntity;

/**
 * @author anish
 * @project lms
 */
public interface BookRecordService {

    ResponseEntity<?> saveBookRecord(BookRecordDTO dto);

    ResponseEntity<?> deleteSavedBookRecord(BookRecordDTO dto);
}
