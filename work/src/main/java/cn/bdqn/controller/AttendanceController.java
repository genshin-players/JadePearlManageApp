package cn.bdqn.controller;


import cn.bdqn.service.AttendenceService;
import cn.bdqn.vo.ClassAttendanceCardInfoVO;
import cn.bdqn.vo.ClassAttendanceDetailInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AttendanceController {
    @Autowired
    AttendenceService attendenceService;



    @RequestMapping("/classAttendance.html")
    public Map<String,Object> classAttendanceCardList(String attendanceDate){
        Map<String,Object>map=new HashMap<>();
        try{
            List<ClassAttendanceCardInfoVO> classAttendanceInfo = attendenceService.getClassAttendanceInfo(attendanceDate);
            map.put("data",classAttendanceInfo);
            map.put("msg","success");
            map.put("code","200");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","error");
            map.put("code","500");
        }
        return map;
    }


    @RequestMapping("/classAttendanceDetail.html")
    public Map<String,Object> classAttendanceDetail(String attendanceDate, Integer classId){
        Map<String,Object>map=new HashMap<>();
        try{
            List<ClassAttendanceDetailInfoVO> classAttendanceDetailInfo=attendenceService.getClassAttendanceDetailInfo(attendanceDate, classId);
            map.put("data",classAttendanceDetailInfo);
            map.put("msg","success");
            map.put("code","200");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","error");
            map.put("code","500");
        }
        return map;
    }


}
