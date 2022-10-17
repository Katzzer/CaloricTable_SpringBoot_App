package com.pavelkostal.Caloric.Tables.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PageControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void itShouldRedirectToCustomerInformationPage() throws Exception {
        // Given
        // When
        // Then
        mockMvc.perform(get("/")).andDo(print())
                .andExpect(redirectedUrl("/customer-information"));
    }

    @Test
    void itShouldRedirectToLoginPage() throws Exception {
        // Given
        // When
        // Then
        mockMvc.perform(get("/customer-information")).andDo(print())
                .andExpect(status().is3xxRedirection());
    }


}
