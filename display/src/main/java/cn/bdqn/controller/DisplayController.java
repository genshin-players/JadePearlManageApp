package cn.bdqn.controller;


import cn.bdqn.entity.Display;
import cn.bdqn.service.IDisplayService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @RequestMapping("deleteDisplay")
    public Map<String, Object> deleteDisplay(@RequestParam(value = "id") Integer id){
        boolean b = displayService.removeById(id);
        Map<String,Object> map = new HashMap<>();
        if (b){
            map.put("code", 200);
            map.put("msg", "success");
        }else {
            map.put("code", 500);
            map.put("msg", "error");
        }
        return map;
    }


    @RequestMapping("addDisplay")
    public Map<String, Object> addDisplay(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "displayTypeId") Integer displayTypeId,
            @RequestParam(value = "coverImage", defaultValue = "1", required = false) String coverImage,
            @RequestParam(value = "publishUserId", defaultValue = "1", required = false) Integer publishUserId,
            @RequestParam(value = "createTime", required = false) Date createTime)
    {
        Map<String,Object> map = new HashMap<>();
        if (displayService.save(
                Display.builder()
                        .title(title)
                        .displayTypeId(displayTypeId)
                        .coverImage(coverImage)
                        .publishUserId(publishUserId)
                        .createTime(createTime)
                        .updateTime(new Date())
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

    @RequestMapping("getDisplayIdByCreationTimeAndTitle")
    public Integer getCreatedByCreationTimeAndTitle(
            @RequestParam(value = "updateTime") String updateTime,
            @RequestParam(value = "title")String title
    ){
        LambdaQueryWrapper<Display> lambdaQueryWrapper = new LambdaQueryWrapper<Display>();
        lambdaQueryWrapper.eq(Display::getTitle,title);
        lambdaQueryWrapper.eq(Display::getUpdateTime,updateTime);
        List<Display> list = displayService.list(lambdaQueryWrapper);
        return list.get(0).getId();
    }
}

