package com.tonasolution.controller;

import com.tonasolution.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    private final DemoService demoService;

    //== constructors ==
    @Autowired
    public DemoController (DemoService demoService) {
        this.demoService = demoService;
    }

    // == request methods ==

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("welcome")
    public String welcome(Model model) {

        model.addAttribute("helloUser", demoService.getHelloMessage("Tim"));
        log.info("model = {}", model);
        return "welcome";
    }

    // == model attributes ==

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
