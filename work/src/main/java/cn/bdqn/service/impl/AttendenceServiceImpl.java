package cn.bdqn.service.impl;

import cn.bdqn.entity.Attendence;
import cn.bdqn.entity.Class;
import cn.bdqn.entity.Classes;
import cn.bdqn.entity.Users;
import cn.bdqn.mapper.AttendenceMapper;
import cn.bdqn.mapper.ClassMapper;
import cn.bdqn.mapper.ClassesMapper;
import cn.bdqn.mapper.UsersMapper;
import cn.bdqn.service.AttendenceService;
import cn.bdqn.vo.ClassAttendanceCardInfoVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 出勤 服务实现类
 * </p>
 *
 * @author 
 * @since 2023-06-09
 */
@Service
public class AttendenceServiceImpl extends ServiceImpl<AttendenceMapper, Attendence> implements AttendenceService {
    @Autowired
    AttendenceMapper attendenceMapper;
    @Autowired
    ClassesMapper classesMapper;
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    ClassMapper classMapper;

    /**
     * 班级出勤页面卡片展示 按班级和出勤日期展示数据
     *
     * @return map集合包含
     */
    @Override
    public List<ClassAttendanceCardInfoVO> getClassAttendanceInfo(String attendanceDate) {
        //此集合保存页面上每一个卡片的数据
        List<ClassAttendanceCardInfoVO> classAttendanceCardInfoList=new ArrayList<>();




        //查询所有班级的集合
        List<Classes>classesList=classesMapper.selectList(null);
        //循环将每个班卡片数据保存到集合
        for(Classes classes:classesList){
            ClassAttendanceCardInfoVO vo=new ClassAttendanceCardInfoVO();
            //保存班级信息
            vo.setClasses(classes);
            //班级总人数
            QueryWrapper<Class> classSizeWrapper=new QueryWrapper<>();
            classSizeWrapper.eq("class_id",classes.getId());
            vo.setClassSize(classMapper.selectCount(classSizeWrapper)-2);
            //出勤人数
            QueryWrapper<Attendence> attendanceNumWrapper=new QueryWrapper<>();
            attendanceNumWrapper.like("date",attendanceDate+"%");
            attendanceNumWrapper.eq("class_id",classes.getId());
            attendanceNumWrapper.eq("is_present",2);
            vo.setAttendanceNumber(attendenceMapper.selectCount(attendanceNumWrapper));
            //缺勤人数
            QueryWrapper<Attendence> absenteesNumWrapper=new QueryWrapper<>();
            absenteesNumWrapper.like("date",attendanceDate+"%");
            absenteesNumWrapper.eq("class_id",classes.getId());
            absenteesNumWrapper.eq("is_present",0);
            vo.setAbsenteesNumber(attendenceMapper.selectCount(absenteesNumWrapper));
            //迟到人数
            QueryWrapper<Attendence> latecomersNumWrapper=new QueryWrapper<>();
            latecomersNumWrapper.like("date",attendanceDate+"%");
            latecomersNumWrapper.eq("class_id",classes.getId());
            latecomersNumWrapper.eq("is_present",1);
            vo.setLatecomersNumber(attendenceMapper.selectCount(latecomersNumWrapper));
            //请假人数
            QueryWrapper<Attendence> leaverNumWrapper=new QueryWrapper<>();
            leaverNumWrapper.like("date",attendanceDate+"%");
            leaverNumWrapper.eq("class_id",classes.getId());
            leaverNumWrapper.eq("is_present",3);
            vo.setLeaverNumber(attendenceMapper.selectCount(leaverNumWrapper));
            //汇报人对象
            QueryWrapper<Attendence> reportWrapper=new QueryWrapper<>();
            reportWrapper.like("date",attendanceDate+"%");
            reportWrapper.eq("class_id",classes.getId());
            List<Attendence> attendences = attendenceMapper.selectList(reportWrapper);
            Users user=usersMapper.selectById(attendences.get(0).getReportUserId());
            vo.setReportUser(user);
            //汇报时间
            QueryWrapper<Attendence> reportDateWrapper=new QueryWrapper<>();
            reportDateWrapper.like("date",attendanceDate+"%");
            reportDateWrapper.eq("class_id",classes.getId());
            List<Attendence> attendences2 = attendenceMapper.selectList(reportDateWrapper);

            vo.setAttendanceDate(attendenceMapper.selectList(reportDateWrapper).get(0).getDate());
            //数据加入集合
            classAttendanceCardInfoList.add(vo);
        }




        return classAttendanceCardInfoList;
    }
}
