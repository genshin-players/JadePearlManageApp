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

import java.util.*;

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

    @RequestMapping("/activitiesListByTitle")
    public List<ActivitiesDTO> activitiesListByTitle(@RequestParam(value = "title") String title){
        LambdaQueryWrapper<Display> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(Display::getTitle, "%"+title+"%");
        List<Display> displayList = displayService.list(lambdaQueryWrapper);
        for (Display display : displayList){
            LambdaQueryWrapper<Display> lambdaQueryWrapper2 = new LambdaQueryWrapper<>();
            lambdaQueryWrapper2.like(Display::getTitle, "%"+title+"%");
            //List<Display> displayList = displayService.list(lambdaQueryWrapper);
        }
/*        List<Activities> list = activitiesService.list();
        List<ActivitiesDTO> dtoList = new ArrayList<>();
        for (Activities activities:list){
            ActivitiesDTO activitiesDTO = new ActivitiesDTO();
            BeanUtils.copyProperties(activities, activitiesDTO);
            int displayId =activities.getDisplayId();
            Display display = displayService.getById(displayId);
            activitiesDTO.setDisplay(display);
            dtoList.add(activitiesDTO);
        }*/
        return dtoList;
    }

    @RequestMapping("deleteActivitiesById")
    public Map<String, Object> deleteActivitiesById(@RequestParam(value = "activitiesId") Integer activitiesId,@RequestParam(value = "displayId") Integer displayId){
        boolean activitiesB = activitiesService.removeById(activitiesId);
        boolean displayB = displayService.removeById(displayId);
        Map<String,Object> map = new HashMap<>();
        if (activitiesB && displayB){
            map.put("code", 200);
            map.put("msg", "success");
        }else {
            map.put("code", 500);
            map.put("msg", "error");
        }
        return map;
    }

    @RequestMapping("addActivities")
    public Map<String, Object> addActivities(
            @RequestParam(value = "displayId") Integer displayId,
            @RequestParam(value = "signupNumber") Integer signupNumber,
            @RequestParam(value = "startTime") Date startTime,
            @RequestParam(value = "endTime") Date endTime){
        Map<String,Object> map = new HashMap<>();
        if (activitiesService.save(
                Activities.builder()
                        .displayId(displayId)
                        .signupNumber(signupNumber)
                        .startTime(startTime)
                        .endTime(endTime)
                        .build()
        )){
            map.put("code", 200);
            map.put("msg", "success");
        }else {
            map.put("code", 500);
            map.put("msg", "error");
        }
        return map;
    }

}

