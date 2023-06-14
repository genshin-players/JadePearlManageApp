package cn.bdqn.controller;

import cn.bdqn.client.UserClient;
import cn.bdqn.entity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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


    @PostMapping("/add_user")
    public  String addUser(Users users,String username,String  realname,
                           String age,String gender,
                           String phone,String identity){

        //"realname":"林忆宁","age":"25","gender":"女","phone":"13361887757","identity":"310106199707170028"
        System.out.println(username);
        System.out.println(realname);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(phone);
        System.out.println(identity);
        users.setIdentityInfo("realname:"+realname);
        Map<String, Object> map = userClient.addUser(users);
        System.out.println(map);
        return "redirect:show_teacher";
    }

    /*ly所需接口*/
    @RequestMapping("/user/selectUsersById")
    public String selectUsersById(Integer id,Model model){
        Users users = userClient.selectUsersById(id);
        System.out.println(users.getId()+"今天天气真好");
        model.addAttribute("usersById",users);
        System.out.println(users.getUsername()+"hhhhhhhhhhhhhhhhhhhh");
        return "messages/update_Select";
    }


}
