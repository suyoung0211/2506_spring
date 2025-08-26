package org.iclass.spring_8secu.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
public class UsersController {
    @GetMapping("/login")
    public String login() {
        return "login"; // login.thml
    }
    
    @GetMapping("/signup")
    public String signup() {
        return "signup"; // signup.thml
    }
}
