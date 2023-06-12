package cn.bdqn.controller;


import cn.bdqn.entity.Activities;
import cn.bdqn.service.IActivitiesService;
import cn.bdqn.service.IDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dddqmmx
 * @since 2023-06-09
 */
@Controller
@RequestMapping("/activities")
public class ActivitiesController {

    @Autowired
    private IActivitiesService activitiesService;
    @Autowired
    private IDisplayService displayService;

    @RequestMapping("/activitiesList")
    public List<Activities> getActivitiesList(){
        List<Activities> list = activitiesService.list();
        for (Activities activities:list){
            int displayId =activities.getDisplayId();
            displayService.getById(displayId);
        }
        return list;
    }
}

