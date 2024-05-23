package com.learn.lms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author anish
 * @project lms
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "LMS_BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "isbnnumber")
    private String isbnNumber;

    private Book(BookBuilder builder ) {
        this.id = builder.id;
        this.name = builder.name;
        this.author = builder.author;
        this.isbnNumber = builder.isbnNumber;
    }

    public static class BookBuilder{

        private long id;

        private String name;

        private String author;

        private String isbnNumber;


        public BookBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public BookBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setIsbnNumber(String isbnNumber) {
            this.isbnNumber = isbnNumber;
            return this;
        }

        public Book build() {return new Book(this);}
    }
}
