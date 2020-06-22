package com.example.zdsc.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.zdsc.entity.EmployeeLeave;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 员工离职信息表 服务类
 * </p>
 *
 * @author 赖允翔
 * @since 2020-06-15
 */
public interface EmployeeLeaveService extends IService<EmployeeLeave> {

    List<EmployeeLeave> selectList1(QueryWrapper<EmployeeLeave> queryWrapper);
}
