package cn.bdqn.client;

import cn.bdqn.vo.workvo.ClassAttendanceCardInfoVO;
import cn.bdqn.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="work")
public interface WorkClient {

    @RequestMapping("/classAttendance.html")
    ResultVO<List<ClassAttendanceCardInfoVO>> classAttendanceCardList(@RequestParam("attendanceDate") String attendanceDate);

}
