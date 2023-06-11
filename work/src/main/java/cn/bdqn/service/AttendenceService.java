package cn.bdqn.service;

import cn.bdqn.entity.Attendence;
import cn.bdqn.vo.ClassAttendanceCardInfoVO;
import cn.bdqn.vo.ClassAttendanceDetailInfoVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 出勤 服务类
 * </p>
 *
 * @author 
 * @since 2023-06-09
 */
public interface AttendenceService extends IService<Attendence> {

    /**
     *  班级出勤页面卡片展示 按班级和出勤日期展示数据
     * @return map集合包含
     */
    public List<ClassAttendanceCardInfoVO> getClassAttendanceInfo(String attendanceDate);


    /**
     * 班级出勤详情页面展示的信息
     * @param attendanceDate 出勤日期
     * @param classId 班级编号
     * @return 信息集合
     */
    public List<ClassAttendanceDetailInfoVO> getClassAttendanceDetailInfo(String attendanceDate, Integer classId);

}
