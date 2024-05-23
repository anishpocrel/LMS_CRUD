package com.learn.lms.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author anish
 * @project lms
 */
@Data
@NoArgsConstructor

public class BookDTO {

    private long id;

    private String name;

    private String author;

    private String isbnNumber;

    private BookDTO(BookDTOBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.author = builder.author;
        this.isbnNumber = builder.isbnNumber;
    }

    public static class BookDTOBuilder{

        private long id;

        private String name;

        private String author;

        private String isbnNumber;

        public BookDTOBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public BookDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BookDTOBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookDTOBuilder setIsbnNumber(String isbnNumber) {
            this.isbnNumber = isbnNumber;
            return this;
        }

        public BookDTO build(){return new BookDTO(this);}
    }
}
