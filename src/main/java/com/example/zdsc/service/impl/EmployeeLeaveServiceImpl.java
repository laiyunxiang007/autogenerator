package com.example.zdsc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.zdsc.entity.EmployeeLeave;
import com.example.zdsc.mapper.EmployeeLeaveMapper;
import com.example.zdsc.service.EmployeeLeaveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工离职信息表 服务实现类
 * </p>
 *
 * @author 赖允翔
 * @since 2020-06-15
 */
@Service
public class EmployeeLeaveServiceImpl extends ServiceImpl<EmployeeLeaveMapper, EmployeeLeave> implements EmployeeLeaveService {

    @Autowired
    EmployeeLeaveMapper employeeLeaveMapper;
    @Override
    public List<EmployeeLeave> selectList1(QueryWrapper<EmployeeLeave> queryWrapper) {
        return employeeLeaveMapper.selectList1(queryWrapper);
    }
}
