package com.learn.lms.mapper;

import com.learn.lms.dto.BookDTO;
import com.learn.lms.entity.Book;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author anish
 * @project lms
 */
public class BookMapper {

    public static Book toEntity(BookDTO dto){
        return new Book.BookBuilder()
                .setAuthor(dto.getAuthor())
                .setIsbnNumber(dto.getIsbnNumber())
                .setName(dto.getName())
                .build();
    }


    public static BookDTO toDTO(Book entity){
        return new BookDTO.BookDTOBuilder()
                .setAuthor(entity.getAuthor())
                .setName(entity.getName())
                .setIsbnNumber(entity.getIsbnNumber())
                .build();
    }


    public static List<Book> toEntityList(List<BookDTO> dtos){
        return dtos.stream()
                .map(BookMapper::toEntity)
                .collect(Collectors.toList());
    }

    public static List<BookDTO> toDTOList(List<Book> entities){
        return entities.stream()
                .map(BookMapper::toDTO)
                .collect(Collectors.toList());
    }
}
