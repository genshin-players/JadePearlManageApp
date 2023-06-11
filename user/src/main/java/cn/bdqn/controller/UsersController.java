package cn.bdqn.controller;


import cn.bdqn.entity.Users;
import cn.bdqn.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户（所有学生，老师，管理员） 前端控制器
 * </p>
 *
 * @author ljj
 * @since 2023-06-11
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @RequestMapping("showAll")
    private List<Users> getAll(){
        List<Users> list = usersService.list();
        return list;
    }

}
