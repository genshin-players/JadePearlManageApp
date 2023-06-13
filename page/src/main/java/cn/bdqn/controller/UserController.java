package cn.bdqn.controller;

import cn.bdqn.client.UserClient;
import cn.bdqn.entity.Users;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserClient userClient;


    @RequestMapping("show_teacher")
    public String showTeacher(Model model) {
        System.out.println("进来了");
        List<Users> users = userClient.showTeacher();
        model.addAttribute("users",users);
        System.out.println(users);
        return "teacher/show_teacher";
    }


    @RequestMapping("/show_student")
    public String  showStudent(Model model){
        System.out.println("进来了");
        List<Users> users = userClient.showStudent();
        model.addAttribute("users",users);
        System.out.println(users);
        return "student/show_student";
    }
//=============================================================================================
    @RequestMapping("/deleteTeacher")
    public String  deleteTeacher(@RequestParam(value = "id") Integer id){
        Map<String, Object> map = userClient.deleteTeacher(id);
        System.out.println("删除成功");
        System.out.println(id);

        return "redirect:show_teacher";
    }

    @RequestMapping("/deleteStudent")
    public String   deleteStudent(Integer id){
        Map<String, Object> map= userClient.deleteTeacher(id);
        return "redirect:show_student";
    }

//========================================================================================


    /*ly所需接口*/
    @RequestMapping("/user/selectUsersById")
    public String selectUsersById(Integer id,Model model){
        Users users = userClient.selectUsersById(id);
        model.addAttribute("usersById",users);
        return "ly/**";
    }


}
