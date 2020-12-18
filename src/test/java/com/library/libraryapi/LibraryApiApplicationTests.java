package com.library.libraryapi;

import com.library.libraryapi.model.dao.dtos.BookDTO;
import com.library.libraryapi.model.services.BookService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryApiApplicationTests {

    @Autowired
    private  BookService bookService;
    @Autowired
    private MockMvc mockMvc;



    @Test
    void contextLoads() {

    }

}
