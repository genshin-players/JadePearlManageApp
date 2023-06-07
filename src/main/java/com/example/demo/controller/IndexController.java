package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    //学生出勤页面请求
    @RequestMapping("/toStuAttendance")
    public String toStuAttendance(){
        return "work/studentAttendance";
    }
    //学生出勤详情页面请求f
    @RequestMapping("/toStuAttendanceDetail")
    public String toStuAttendanceDetail(String className, String total, String late, String absence, String date, Model model) throws ParseException {
        model.addAttribute("className", className);
        model.addAttribute("total", total);
        model.addAttribute("late", late);
        model.addAttribute("absence", absence);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=sdf.parse(date);
        model.addAttribute("date", date1);
        return "work/studentAttendanceDetail";
    }

    //学社出勤页面请求
    @RequestMapping("/toMembersAttendance")
    public String toMembersAttendance(){
        return "work/MembersAttendance";
    }
}
