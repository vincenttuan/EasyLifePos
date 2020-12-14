package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/greet")
public class Greet {
    
    @RequestMapping("/welcome/{username}")
    public String welcome(@PathVariable String username, Model model) {
        model.addAttribute("username", username);
        return "welcome_page";
    }
    
}
