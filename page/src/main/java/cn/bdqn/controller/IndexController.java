package cn.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
