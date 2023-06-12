package cn.bdqn.controller;

import cn.bdqn.client.ActivatesClient;
import cn.bdqn.client.DisplayClient;
import cn.bdqn.client.WorkClient;
import cn.bdqn.dto.ActivitiesDTO;
import cn.bdqn.dto.DisplayDTO;
import cn.bdqn.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/display")
public class DisplayController {
    @Autowired
    private DisplayClient displayClient;
    @Autowired
    private ActivatesClient activatesClient;
    @RequestMapping("/daily_info")
    public String toDailyInfo(Model model) {
        ResultVO<List<DisplayDTO>> pushEveryFuckingDayList = displayClient.getPushEveryFuckingDayList();
        List<DisplayDTO> displayDTOList = pushEveryFuckingDayList.getData();
/*        for (DisplayDTO displayDTO:displayDTOList){
            System.out.println(displayDTO.getTitle());
        }*/
        model.addAttribute("displayDTOList",displayDTOList);
        return "display/daily_info";
    }
    @RequestMapping("/inner_activities")
    public String toInnerActivities(Model model) {
        List<ActivitiesDTO> activitiesList = activatesClient.getActivitiesList();
        for (ActivitiesDTO activitiesDTO:activitiesList){
            System.out.println(activitiesDTO.getDisplay().getTitle());
        }
        model.addAttribute("activitiesList",activitiesList);
        return "display/inner_activities";
    }

    @RequestMapping("/external_performance")
    public String toExternalPerformance(Model model) {
        ResultVO<List<DisplayDTO>> externalPerformanceList = displayClient.getExternalPerformanceList();
        List<DisplayDTO> displayDTOList = externalPerformanceList.getData();
/*        for (DisplayDTO displayDTO:displayDTOList){
            System.out.println(displayDTO.getTitle());
        }*/
        model.addAttribute("displayDTOList",displayDTOList);
        return "display/external_performance";
    }

    @RequestMapping("/editor")
    public String toEditor(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String signupNum,
            @RequestParam(required = false) String startTime,
            @RequestParam(required = false) String endTime,
            Model model){
        model.addAttribute("type", "".equals(type.trim())?"Display":type);
        model.addAttribute("signupNum",signupNum==null?"":signupNum);
        model.addAttribute("startTime",startTime==null?"":startTime);
        model.addAttribute("endTime",endTime==null?"":endTime);
        return "display/editor";
    }

    @RequestMapping("/edit_activities")
    public String toEditorActivites(Model model){
        return "display/edit_activities";
    }
}