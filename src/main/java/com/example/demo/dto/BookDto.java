package com.example.demo.dto;

import com.example.demo.validator.ValidDate;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {

    private Long id;

    @NotBlank(message = "Book title cannot be blank")
    private String title;

    @NotBlank(message = "Book author cannot be blank")
    private String author;

    @ValidDate(message = "Published Date must be from B.E. 1000 to current year (in Buddhist calendar)")
    private String publishedDate;
}
