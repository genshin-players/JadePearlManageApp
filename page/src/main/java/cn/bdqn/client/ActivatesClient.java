package cn.bdqn.client;

import cn.bdqn.dto.ActivitiesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@FeignClient(name = "display")
@RequestMapping("/activities")
public interface ActivatesClient {

    @RequestMapping("/activitiesList")
    List<ActivitiesDTO> getActivitiesList();

    @RequestMapping("deleteActivitiesById")
    Map<String, Object> deleteActivitiesById(@RequestParam(value = "activitiesId") Integer activitiesId, @RequestParam(value = "displayId") Integer displayId);

    @RequestMapping("addActivities")
    Map<String, Object> addActivities(
            @RequestParam(value = "displayId") Integer displayId,
            @RequestParam(value = "signupNumber") Integer signupNumber,
            @RequestParam(value = "startTime") Date startTime,
            @RequestParam(value = "endTime") Date endTime);

}
