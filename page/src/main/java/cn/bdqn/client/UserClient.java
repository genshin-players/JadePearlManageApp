package cn.bdqn.client;

import cn.bdqn.entity.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@Component
@FeignClient(value="userabc")
public interface UserClient {

    @RequestMapping("/user/showTeacher")
    List<Users> showTeacher();


    @RequestMapping("/user/showStudent")
    List<Users> showStudent();


    @RequestMapping("user/deleteTeacher_Student")
    Map<String, Object>  deleteTeacher(@RequestParam(value = "id")  Integer id);

    @PostMapping("/user/addUser")
    Map<String,Object>  addUser(@RequestParam Users users);


    /*ly所需接口*/
    @RequestMapping("/user/selectUsersById")
    Users selectUsersById(@RequestParam(value = "id")Integer id);


}
