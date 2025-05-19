package com.lecimangga.lecimanggaresidence.api.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String register(HttpSession session) {
        return "register";
    }
}

