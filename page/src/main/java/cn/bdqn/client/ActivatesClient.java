package cn.bdqn.client;

import cn.bdqn.dto.ActivitiesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "display")
@RequestMapping("/activities")
public interface ActivatesClient {

    @RequestMapping("/activitiesList")
    List<ActivitiesDTO> getActivitiesList();

}
