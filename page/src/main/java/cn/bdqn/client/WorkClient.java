package cn.bdqn.client;

import cn.bdqn.vo.workvo.ClassAttendanceCardInfoVO;
import cn.bdqn.vo.ResultVO;
import cn.bdqn.vo.workvo.ClassAttendanceDetailInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name="work")
public interface WorkClient {

    @RequestMapping("/classAttendance.html")
    ResultVO<List<ClassAttendanceCardInfoVO>> classAttendanceCardList(@RequestParam("attendanceDate") String attendanceDate);

    @RequestMapping("/classAttendanceDetail.html")
    public ResultVO<List<ClassAttendanceDetailInfoVO>> classAttendanceDetail(@RequestParam("attendanceDate")String attendanceDate, @RequestParam("classId") Integer classId);

}
