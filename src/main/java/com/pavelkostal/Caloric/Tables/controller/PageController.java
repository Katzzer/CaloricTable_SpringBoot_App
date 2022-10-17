package com.pavelkostal.Caloric.Tables.controller;

import com.pavelkostal.Caloric.Tables.entity.Customer;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PageController {

    @GetMapping("/")
    public String helloWorld() {
        return "index";
    }


    @GetMapping("/registerCustomer")
    public String registerCustomer(
            @AuthenticationPrincipal OAuth2User oAuth2User,
            Model model
    ) {
        Customer newCustomer = new Customer();

        model.addAttribute("userName", oAuth2User.getAttribute("name"));
        model.addAttribute("customer", newCustomer);
        return "register";
    }

    @PostMapping("/registerCustomer")
    public String saveNewCustomer(@ModelAttribute Customer customer) {
        return "register";
    }
}
