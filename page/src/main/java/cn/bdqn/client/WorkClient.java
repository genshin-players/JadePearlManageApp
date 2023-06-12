package cn.bdqn.client;

import cn.bdqn.entity.Attendence;
import cn.bdqn.vo.workvo.ClassAttendanceCardInfoVO;
import cn.bdqn.vo.ResultVO;
import cn.bdqn.vo.workvo.ClassAttendanceDetailInfoVO;
import cn.bdqn.vo.workvo.ToStudentAttendancePageVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name="work")
public interface WorkClient {

    @RequestMapping("/classAttendance.html")
    public ResultVO<List<ClassAttendanceCardInfoVO>> classAttendanceCardList(@RequestParam("attendanceDate") String attendanceDate);

    @RequestMapping("/classAttendanceDetail.html")
    public ResultVO<List<ClassAttendanceDetailInfoVO>> classAttendanceDetail(@RequestParam("attendanceDate")String attendanceDate, @RequestParam("classId") Integer classId);

    /**
     * 去添加学生出勤页面所需要的数据
     * @return 数据
     */
    @RequestMapping("/toStudentAttendancePage")
    public ResultVO<ToStudentAttendancePageVO> toStudentAttendancePageVO();


    @PostMapping("/addStudentAttendance")
    public ResultVO<Integer> addStudentAttendance(@SpringQueryMap Attendence attendence);

}
