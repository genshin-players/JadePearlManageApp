package cn.bdqn.service.impl;

import cn.bdqn.entity.Class;
import cn.bdqn.mapper.ClassMapper;
import cn.bdqn.service.ClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 学生与班级绑定表 服务实现类
 * </p>
 *
 * @author 
 * @since 2023-06-09
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {

}
