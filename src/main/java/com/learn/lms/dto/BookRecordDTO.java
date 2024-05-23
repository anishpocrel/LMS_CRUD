package com.learn.lms.dto;

import java.util.List;
import lombok.Data;

/**
 * @author anish
 * @project lms
 */
@Data
public class BookRecordDTO {

    private List<Long> bookId;

    private long userId;
}
