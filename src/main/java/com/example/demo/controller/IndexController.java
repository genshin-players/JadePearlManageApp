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

    @RequestMapping("teacher")
    public String teacher(){
        return "teacher/teacher";
    }

    @RequestMapping("update_addteacher")
    public String update_addteacher(){
        return "teacher/update_addteacher";
    }

    @RequestMapping("showteacher")
    public String showteacher(){
        return "teacher/showteacher";
    }



    @RequestMapping("student")
    public String student(){
        return "student/student";
    }

    @RequestMapping("update_addstudent")
    public String update_addstudent(){
        return "student/update_addstudent";
    }

    @RequestMapping("showstudent")
    public String showstudent(){
        return "student/showstudent";
    }



}
