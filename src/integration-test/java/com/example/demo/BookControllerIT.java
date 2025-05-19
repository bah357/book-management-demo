package com.example.demo;

import com.example.demo.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureDataJpa
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerIT {

    @Autowired
    private MockMvc mockMvc;

    /*@Test
    public void TestGetEndpoint() throws Exception {
        mockMvc.perform(get("/books/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.message")
                        .value("Hello, world!"));
    }*/

    /*
    Still not working, test case cannot be detected.
     */
    @Test
    void ShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(post("/books",
                        BookDto.builder()
                                .title("Book title")
                                .author("John Doe")
                                .build()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Book added successfully")));
    }
}
