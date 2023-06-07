package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayController {
    @RequestMapping("/push_every_fucking_day")
    public String display() {
        return "display";
    }
}
