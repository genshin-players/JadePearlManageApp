package cn.bdqn.service;

import cn.bdqn.entity.Schedules;
import cn.bdqn.vo.MemberWorkCardInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 学社成员工作安排 服务类
 * </p>
 *
 * @author 
 * @since 2023-06-09
 */
public interface SchedulesService extends IService<Schedules> {

    /**
     * 学社出勤页面展示工作卡片的数据
     * @param workDate 工作日期
     * @return 卡片上的数据
     */
    public List<MemberWorkCardInfoVO> getMemberWorkCardInfo(String workDate);

}
