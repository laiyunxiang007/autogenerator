package com.example.zdsc.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.zdsc.entity.EmployeeLeave;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 员工离职信息表 Mapper 接口
 * </p>
 *
 * @author 赖允翔
 * @since 2020-06-15
 */
@Mapper
public interface EmployeeLeaveMapper extends BaseMapper<EmployeeLeave> {

    List<EmployeeLeave> selectList1(@Param("ew") QueryWrapper<EmployeeLeave> queryWrapper);
}
