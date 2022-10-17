package com.pavelkostal.Caloric.Tables.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    OAuth2User oAuth2UserForTesting;

    final String testingUserName = "testingUser";
    final String testingUserEmail = "testing@gmail.com";


    @BeforeEach
    void setUp() {
        oAuth2UserForTesting = new OAuth2User() {
            @Override
            public Map<String, Object> getAttributes() {
                HashMap<String, Object> attributes = new HashMap<>();
                attributes.put("name", testingUserName);
                attributes.put("email", testingUserEmail);
                return attributes;
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getName() {
                return testingUserName;
            }
        };

        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("It should redirect to /customer-information")
    void itShouldRedirectToCustomerInformationPage() throws Exception {
        // Given
        // When
        // Then
        mockMvc.perform(get("/")).andDo(print())
                .andExpect(redirectedUrl("/customer-information"));
    }

    @Test
    @DisplayName("It should redirect to login page")
    void itShouldRedirectToLoginPage() throws Exception {
        // Given
        // When
        // Then
        mockMvc.perform(get("/customer-information")).andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    @DisplayName("Show page /customer-information")
    void itShouldShowPageRegisterCustomerV2() throws Exception {
        // Given

        // When

        // Then
        mockMvc
                .perform(get("/customer-information").with(oauth2Login()))
                .andExpect(status().isOk())
                .andExpect(model().attribute("registerOrUpdate", "Register"));
    }

}
