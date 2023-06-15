package cn.bdqn.service.impl;


import cn.bdqn.entity.Classes;
import cn.bdqn.mapper.ClassesMapper;
import cn.bdqn.service.IClassesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 班级 服务实现类
 * </p>
 *
 * @author pb
 * @since 2023-06-15
 */
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements IClassesService {

}
