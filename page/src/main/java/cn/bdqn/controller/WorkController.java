package cn.bdqn.controller;

import cn.bdqn.client.WorkClient;
import cn.bdqn.vo.workvo.ClassAttendanceCardInfoVO;
import cn.bdqn.vo.ResultVO;
import cn.bdqn.vo.workvo.ClassAttendanceDetailInfoVO;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.errorprone.annotations.FormatString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@CrossOrigin
public class WorkController {
    @Autowired
    WorkClient workClient;

    //学生出勤页面请求
    @RequestMapping("/toStuAttendance")
    public String toStuAttendance(@RequestParam(required = false) String attendanceDate,Model model){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if(attendanceDate==null){
            attendanceDate=sdf.format(new Date());
        }else {
            try {
                Date date=sdf.parse(attendanceDate);
                attendanceDate=sdf.format(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        ResultVO<List<ClassAttendanceCardInfoVO>> resultVO = workClient.classAttendanceCardList(attendanceDate);
        model.addAttribute("resultVO",resultVO);
        model.addAttribute("pageDate",attendanceDate);
        return "work/studentAttendance";
    }


    //学生出勤详情页面请求
    @RequestMapping("/toStuAttendanceDetail")
    public String toStuAttendanceDetail(String attendanceDate,Integer classId,Model model) {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        if(attendanceDate==null){
            attendanceDate=sdf.format(new Date());
        }else {
            try {
                Date date=sdf.parse(attendanceDate);
                attendanceDate=sdf.format(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        ResultVO<List<ClassAttendanceDetailInfoVO>> resultVO=workClient.classAttendanceDetail(attendanceDate,classId);
        model.addAttribute("resultVO",resultVO);
        model.addAttribute("pageDate",attendanceDate);
        model.addAttribute("classes",resultVO.getData().get(0).getClasses());

        return "work/studentAttendanceDetail";
    }

    //学社出勤页面请求
    @RequestMapping("/toMembersAttendance")
    public String toMembersAttendance(){
        return "work/MembersAttendance";
    }

    //学社出勤详情页面请求
    @RequestMapping("/toMemAttendanceDetail")
    public String toMemAttendanceDetail(String memName,String date,Model model) throws ParseException {
        model.addAttribute("memName", memName);


        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=sdf.parse(date);
        model.addAttribute("date", date1);
        return "work/MembersAttendanceDetail";
    }



    //班级出勤编辑页面请求
    @RequestMapping("/toEditStudentAttendance")
    public String toEditStudentAttendance(){
        return "work/editStudentAttendance";
    }



    //安排工作页面
    @RequestMapping("/toAssignWork")
    public String toAssignOneWork(@RequestParam(required = false) String memName, Model model){
        if(memName!=null){
            model.addAttribute("memName", memName);
        }else {
            model.addAttribute("memName", "sb");
        }
        return "work/assignWork";
    }
}
