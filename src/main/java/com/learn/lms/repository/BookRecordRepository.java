package com.learn.lms.repository;

import com.learn.lms.entity.Book;
import com.learn.lms.entity.BookRecord;
import com.learn.lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author anish
 * @project lms
 */
public interface BookRecordRepository extends JpaRepository<BookRecord, Long> {

    @Modifying
    @Transactional
    @Query("delete from BookRecord where user=?1 and book=?2")
    void deleteByBookAndUserId(User user, Book book);
}
