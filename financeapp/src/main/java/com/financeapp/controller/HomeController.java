package com.financeapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              Model model) {
        if ("user".equals(username) && "password".equals(password)) {
            model.addAttribute("username", username);
            return "login-success";
        } else {
            return "login-error";
        }
    }

    @GetMapping("/budget")
    public String budget() {
        return "budget";
    }

    @GetMapping("/investments")
    public String investments() {
        return "investments";
    }
}
