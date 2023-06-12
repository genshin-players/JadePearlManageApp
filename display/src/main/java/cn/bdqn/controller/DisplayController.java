package cn.bdqn.controller;


import cn.bdqn.entity.Display;
import cn.bdqn.entity.DisplayType;
import cn.bdqn.service.IDisplayService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 显示内容 前端控制器
 * </p>
 *
 * @author dddqmmx
 * @since 2023-06-09
 */
@RestController
@CrossOrigin
@RequestMapping("display")
public class DisplayController {

    @Autowired
    private IDisplayService displayService;

    @RequestMapping("getPushEveryFuckingDayList")
    public Map<String, Object> getPushEveryFuckingDayList(@RequestParam(required = false,defaultValue = "") String title){
        System.out.println("sssss");
        LambdaQueryWrapper<Display> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Display::getDisplayTypeId,2);
        lambdaQueryWrapper.like(Display::getTitle,"%"+title+"%");
        Map<String,Object> map = new HashMap<>();
        List<Display> list = displayService.list(lambdaQueryWrapper);
        if (list != null){
            map.put("code", 200);
            map.put("msg", "success");
            map.put("data", list);
        }else {
            map.put("code", 500);
            map.put("msg", "error");
        }
        return map;
    }

    @RequestMapping("getExternalPerformanceList")
    public Map<String, Object> getExternalPerformanceList(@RequestParam(required = false,defaultValue = "") String title){
        LambdaQueryWrapper<Display> lambdaQueryWrapper = new LambdaQueryWrapper<Display>();
        lambdaQueryWrapper.eq(Display::getDisplayTypeId,3);
        lambdaQueryWrapper.like(Display::getTitle,"%"+title+"%");
        Map<String,Object> map = new HashMap<>();
        List<Display> list = displayService.list(lambdaQueryWrapper);
        if (list != null){
            map.put("code", 200);
            map.put("msg", "success");
            map.put("data", list);
        }else {
            map.put("code", 500);
            map.put("msg", "error");
        }
        return map;
    }
}

