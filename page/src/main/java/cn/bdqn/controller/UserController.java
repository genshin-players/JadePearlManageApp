package cn.bdqn.controller;

import cn.bdqn.client.UserClient;
import cn.bdqn.entity.Classes;
import cn.bdqn.entity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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


    @PostMapping("/add_Tuser")
    public  String addTUser(@RequestParam(value = "username")String username,
                           @RequestParam(value = "realname") String  realname,
                           @RequestParam(value = "age") String age,
                           @RequestParam(value = "gender")String gender,
                           @RequestParam(value = "phone") String phone,
                           @RequestParam(value = "identity") String identity){
        Users users=new Users();
        users.setUsername(username);
        users.setPassword("123456");
        users.setCreateTime(new Date());
        users.setUpdateTime(new Date());
        users.setRoleId(3);
        users.setIdentityInfo("{"+
                '"'+"realname"+'"'+":"+'"'+realname+'"'+","+
                '"'+"age"+'"'+":"+'"'+age+'"'+","+
                '"'+"gender"+'"'+":"+'"'+gender+'"'+","+
                '"'+"phone"+'"'+":"+'"'+phone+'"'+","+
                '"'+"identity"+'"'+":"+'"'+identity+'"'
                +"}");
        Map<String, Object> map = userClient.addUser(users);
        System.out.println(map);
        return "redirect:show_teacher";
    }

    @PostMapping("/add_Suser")
    public  String addSUser(@RequestParam(value = "username")String username,
                           @RequestParam(value = "realname") String  realname,
                           @RequestParam(value = "age") String age,
                           @RequestParam(value = "gender")String gender,
                           @RequestParam(value = "phone") String phone,
                           @RequestParam(value = "identity") String identity){
        Users users=new Users();
        users.setUsername(username);
        users.setPassword("123456");
        users.setCreateTime(new Date());
        users.setUpdateTime(new Date());
        users.setRoleId(6);
        users.setIdentityInfo("{"+
                '"'+"realname"+'"'+":"+'"'+realname+'"'+","+
                '"'+"age"+'"'+":"+'"'+age+'"'+","+
                '"'+"gender"+'"'+":"+'"'+gender+'"'+","+
                '"'+"phone"+'"'+":"+'"'+phone+'"'+","+
                '"'+"identity"+'"'+":"+'"'+identity+'"'
                +"}");
        Map<String, Object> map = userClient.addUser(users);
        System.out.println(map);
        return "redirect:show_student";
    }



    @RequestMapping("/showUser_ById")
    private String showUserById(@RequestParam(value = "id") Integer id,Model model){
        Users users = userClient.showUserById(id);
        model.addAttribute("users",users);
        return "teacher/update_addteacher";


    }


    //查询所有的班级
   /* @ResponseBody
    @RequestMapping("showClass")
    private List<Classes> addUser(Model model){
        List<Classes> classes = userClient.showClass();
        model.addAttribute("className",classes);
        return ""

    }*/





    @RequestMapping("getUsersById")
    public String selectUsersById(Integer id,Model model){
        Users users = userClient.selectUsersById(id);
//        model.addAttribute("usersById",users);
        model.addAttribute("usersById",users);
        return "messages/update_Select";
    }

}
