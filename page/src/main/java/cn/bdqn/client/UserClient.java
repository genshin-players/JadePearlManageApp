package cn.bdqn.client;

import cn.bdqn.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@FeignClient(name="userabc")
public interface UserClient {

    @RequestMapping("/user/showTeacher")
    List<Users> showTeacher();


    @RequestMapping("/user/showStudent")
    List<Users> showStudent();


    @RequestMapping("user/deleteTeacher_Student")
    Integer  deleteTeacher(Integer id);


    /*ly所需接口*/
    @RequestMapping("/user/selectUsersById")
    Users selectUsersById(Integer id);


}
