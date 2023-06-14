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
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.bdqn.vo.*;
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
            QueryWrapper<Attendence> test=new QueryWrapper<>();
            test.like("date",attendanceDate+"%");
            test.eq("class_id",classes.getId());
            List<Attendence> t = attendenceMapper.selectList(test);
            if(t!=null&& t.size()>0){
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
        }




        return classAttendanceCardInfoList;
    }


    /**
     * 班级出勤详情页面展示的信息
     *
     * @param attendanceDate 出勤日期
     * @param classId        班级编号
     * @return 信息集合
     */
    @Override
    public List<ClassAttendanceDetailInfoVO> getClassAttendanceDetailInfo(String attendanceDate, Integer classId) {
        //查询该日期该班级所有学生的出勤记录
        List<Attendence> attendances= attendenceMapper.selectList(
                new QueryWrapper<Attendence>().like("date",attendanceDate+"%").eq("class_id",classId));
        //创建集合用于存储每个学生的信息
        List<ClassAttendanceDetailInfoVO> detailInfoVOList=new ArrayList<>();

        for(Attendence a:attendances){
            ClassAttendanceDetailInfoVO detailVO=new ClassAttendanceDetailInfoVO();
            //出勤记录保存
            detailVO.setAttendence(a);
            //学生保存
            detailVO.setStudent(usersMapper.selectById(a.getStudentId()));
            //班级信息保存
            Classes c=classesMapper.selectById(a.getClassId());
            detailVO.setClasses(c);
            //班主任
            detailVO.setAdviser(usersMapper.selectById(c.getAdviserId()));
            //汇报人信息保存
            detailVO.setReportUser(usersMapper.selectById(a.getReportUserId()));
            detailInfoVOList.add(detailVO);
        }
        return detailInfoVOList;
    }

    /**
     * 去往添加学生出勤记录的页面 需要的数据
     * @return
     */
    public ToStudentAttendancePageVO ToStudentAttendancePage(){
        ToStudentAttendancePageVO pageVO=new ToStudentAttendancePageVO();

        //全部用户列表
        List<Users> users = usersMapper.selectList(null);
        pageVO.setUserList(users);
        //全部班级列表
        List<Classes> classesList = classesMapper.selectList(null);
        pageVO.setClassesList(classesList);
        //学生-班级 对应表
        List<Class> classStudentList = classMapper.selectList(null);
        pageVO.setStudent_class(classStudentList);

        //学生列表 按班级分
        Map<Integer,Object> classStudent=new HashMap<>();
        for (Classes classes:classesList){
            //学生列表
            List<Users> studentC=new ArrayList<>();

            //遍历对应表 得到按班级分的学生列表
            for(Class c:classStudentList){
                if(c.getClassId()==classes.getId()){
                    //循环用户表
                    for(Users u:users){
                        if(c.getStudentId()==u.getId()&&u.getRoleId()==6){
                            studentC.add(u);
                        }
                    }
                }
            }




            classStudent.put(classes.getId(),studentC);
        }

        pageVO.setStudentByClass(classStudent);


        return pageVO;
    }


    /**
     * 添加学生出勤记录
     *
     * @param attendence 出勤记录
     * @return 受影响的行数
     */
    @Override
    public int addStudentAttendance(Attendence attendence) {
        int count = attendenceMapper.insert(attendence);
        return count;
    }

    /**
     * 按学生ID和日期获取出勤记录
     *
     * @param stuId          学生编号
     * @param attendanceDate 出勤日期
     * @return 出勤记录集合
     */
    @Override
    public List<Attendence> getAttendanceByStuIdAndDate(Integer stuId, String attendanceDate) {
        QueryWrapper<Attendence> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("date",attendanceDate+"%");
        queryWrapper.eq("student_id",stuId);

        return attendenceMapper.selectList(queryWrapper);
    }

    /**
     * 修改出勤记录
     *
     * @param attendence 出勤记录及id
     * @return 受影响行数
     */
    @Override
    public int updateStudentAttendance(Attendence attendence) {
        return attendenceMapper.updateById(attendence);
    }

    /**
     * 按id删除出勤记录
     *
     * @param attendanceId 出勤记录id
     * @return 受影响的行数
     */
    @Override
    public int delStudentAttendance(Integer attendanceId) {
        return attendenceMapper.deleteById(attendanceId);
    }
}
