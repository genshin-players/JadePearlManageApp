package cn.bdqn.controller;


import cn.bdqn.entity.Display;
import cn.bdqn.entity.DisplayType;
import cn.bdqn.service.IDisplayService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Controller
@RequestMapping("/display")
public class DisplayController {

    @Autowired
    private IDisplayService displayService;

    @RequestMapping("getPushEveryFuckingDayList")
    @ResponseBody
    public Map<String, Object> getPushEveryFuckingDayList(){
        LambdaQueryWrapper<Display> lambdaQueryWrapper = new LambdaQueryWrapper<Display>();
        lambdaQueryWrapper.eq(Display::getDisplayTypeId,2);
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
    @ResponseBody
    public Map<String, Object> getExternalPerformanceList(){
        LambdaQueryWrapper<Display> lambdaQueryWrapper = new LambdaQueryWrapper<Display>();
        lambdaQueryWrapper.eq(Display::getDisplayTypeId,3);
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

