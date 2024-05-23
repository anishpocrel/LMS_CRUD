package com.learn.lms.controller;

import com.learn.lms.dto.BookRecordDTO;
import com.learn.lms.service.BookRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anish
 * @project lms
 */
@RestController
@RequestMapping(value = "/bookrecord")
@RequiredArgsConstructor
public class BookRecordController {

    private final BookRecordService bookRecordService;

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveBookRecord(@RequestBody BookRecordDTO dto){
        return bookRecordService.saveBookRecord(dto);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<?> deletBookRecord(@RequestBody BookRecordDTO dto){
        return bookRecordService.deleteSavedBookRecord(dto);
    }
}
