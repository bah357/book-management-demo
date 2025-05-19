package com.example.demo.entity;

import com.example.demo.dto.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private Date publishedDate;

    public static Book from(BookDto source) {
        return Book.builder()
                .title(source.getTitle())
                .author(source.getAuthor())
                .publishedDate(Date.valueOf(source.getPublishedDate()))
                .build();
    }
}
