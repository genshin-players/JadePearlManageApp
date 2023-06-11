package cn.bdqn.client;

import cn.bdqn.dto.DisplayDTO;
import cn.bdqn.vo.ResultVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZedFeorius
 * @version 1.0.0
 * @date 06 11 2023  17:30:37
 * @packageName cn.bdqn.client
 * @className DisplayClient
 * @describe TODO
 */
@FeignClient(name = "display")
@RequestMapping("display")
public interface DisplayClient {
    @RequestMapping("getPushEveryFuckingDayList")
    ResultVO<List<DisplayDTO>> getPushEveryFuckingDayList();
    @RequestMapping("getExternalPerformanceList")
    ResultVO<List<DisplayDTO>> getExternalPerformanceList();
}
