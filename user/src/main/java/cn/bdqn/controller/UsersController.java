package cn.bdqn.controller;


import cn.bdqn.entity.Users;
import cn.bdqn.service.IUsersService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户（所有学生，老师，管理员） 前端控制器
 * </p>
 *
 * @author ljj
 * @since 2023-06-11
 */

@RestController

@RequestMapping("/user")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @ResponseBody
    @RequestMapping("showTeacher")
    private  List<Users> showTeacher(){
        QueryWrapper<Users> wrapper=new QueryWrapper<>();
        wrapper.eq("role_id",3);
        /*Map<String,Object> map = new HashMap<>();*/
        List<Users> list = usersService.list(wrapper);
        System.out.println(list);
      /*  if (list != null){
            map.put("code", 200);
            map.put("msg", "success");
            map.put("data", list);
        }else {
            map.put("code", 500);
            map.put("msg", "error");
        }
        return map;*/
        return list;
    }

    @RequestMapping("showStudent")
    private  List<Users> showStudent(){
        QueryWrapper<Users> wrapper=new QueryWrapper<>();
        wrapper.eq("role_id",6);
        List<Users> list = usersService.list(wrapper);
        return list;
    }


    @RequestMapping("deleteTeacher_Student")
    private String deleteTeacher(Integer id){
        QueryWrapper<Users> wrapper=new QueryWrapper<>();
        wrapper.eq("id",id);
        boolean remove = usersService.remove(wrapper);
        if (remove){
            return "删除成功！！！";
        }
        return "失败！！！";
    }


    @RequestMapping("addUser")
    private String addUser(Users users){
        QueryWrapper<Users> wrapper=new QueryWrapper<>();
        boolean b = usersService.saveOrUpdate(users);
        if(b){
            return "success!!!";
        }else {
            return "error!!!";
        }

    }





}
