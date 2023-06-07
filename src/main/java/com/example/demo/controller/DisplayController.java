package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/display")
public class DisplayController {
    @RequestMapping("/daily_info")
    public String toDailyInfo() {
        return "display/daily_info";
    }
    @RequestMapping("/inner_activities")
    public String toInnerActivities() {
        return "display/inner_activities";
    }

    @RequestMapping("/external_performance")
    public String toExternalPerformance() {
        return "display/external_performance";
    }

    @RequestMapping("/editor")
    public String toEditor(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String signupNum,
            @RequestParam(required = false) String startTime,
            @RequestParam(required = false) String endTime,
            Model model){
        model.addAttribute("type", "".equals(type.trim())?"Display":type);
        model.addAttribute("signupNum",signupNum==null?"":signupNum);
        model.addAttribute("startTime",startTime==null?"":startTime);
        model.addAttribute("endTime",endTime==null?"":endTime);
        return "display/editor";
    }

    @RequestMapping("/edit_activities")
    public String toEditorActivites(){
        return "display/edit_activities";
    }
}