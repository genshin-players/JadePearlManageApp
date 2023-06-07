package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZedFeorius
 * @version 1.0.0
 * @date 06 07 2023  15:45:22
 * @packageName com.example.demo.controller
 * @className IndexController
 * @describe TODO
 */
@Controller
@CrossOrigin
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "redirect:/";
    }
}
