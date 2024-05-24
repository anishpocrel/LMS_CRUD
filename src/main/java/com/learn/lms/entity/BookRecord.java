package com.learn.lms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author anish
 * @project lms
 */
@Data
@Entity
@Table(name = "LMS_BOOK_RECORD")
public class BookRecord {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "bookid", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;
}
