package com.learn.lms.repository;

import com.learn.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author anish
 * @project lms
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
