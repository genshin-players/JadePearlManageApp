package cn.bdqn.controller;


import cn.bdqn.dto.ActivitiesDTO;
import cn.bdqn.entity.Activities;
import cn.bdqn.entity.Display;
import cn.bdqn.service.IActivitiesService;
import cn.bdqn.service.IDisplayService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@RequestMapping("/activities")
public class ActivitiesController {

    @Autowired
    private IActivitiesService activitiesService;
    @Autowired
    private IDisplayService displayService;

    @RequestMapping("/activitiesList")
    public List<ActivitiesDTO> getActivitiesList(){
        List<Activities> list = activitiesService.list();
        List<ActivitiesDTO> dtoList = new ArrayList<>();
        for (Activities activities:list){
            ActivitiesDTO activitiesDTO = new ActivitiesDTO();
            BeanUtils.copyProperties(activities, activitiesDTO);
            int displayId =activities.getDisplayId();
            Display display = displayService.getById(displayId);
            activitiesDTO.setDisplay(display);
            dtoList.add(activitiesDTO);
        }
        return dtoList;
    }
}

