package com.tonasolution.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class Demo {

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("welcome")
    public String welcome(Model model) {

        model.addAttribute("user", "Tim");
        log.info("model = {}", model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return "Welcome to this Demo application";
    }
}
