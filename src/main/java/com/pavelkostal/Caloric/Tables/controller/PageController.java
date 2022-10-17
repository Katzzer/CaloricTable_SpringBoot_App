package com.pavelkostal.Caloric.Tables.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class PageController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello world";
    }


    @GetMapping("/registerCustomer")
    public String registerCustomer(
            @AuthenticationPrincipal OAuth2User oAuth2User
    ) {
        return "aaa";
    }
}
