package com.example.zdsc.controller.EmployeeLeave;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bojun.base.controller.BoJunBaseController;
import com.example.zdsc.entity.EmployeeLeave;
import com.example.zdsc.service.EmployeeLeaveService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 员工离职信息表 前端控制器
 * </p>
 *
 * @author 赖允翔
 * @since 2020-06-15
 */
@RestController
public class EmployeeLeaveController extends BoJunBaseController {
    @Autowired
    EmployeeLeaveService employeeLeaveService;

    /**
     * @description: 分页倒叙查
     * @author: 赖允翔
     * @date: 2020/6/15
     * @Param:
     * @return:
     */
    @RequestMapping("/a")
    public List<EmployeeLeave> geta(){
        Page<EmployeeLeave> page=new Page(1,2);
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.orderByDesc("create_time");
        return employeeLeaveService.page(page,queryWrapper).getRecords();
    }

    /**
     * @description: if选择条件查
     * @author: 赖允翔
     * @date: 2020/6/15
     * @Param:
     * @return:
     */
    @RequestMapping("/b")
    public List<EmployeeLeave> getb(@RequestBody EmployeeLeave employeeLeave){

        QueryWrapper<EmployeeLeave> queryWrapper=new QueryWrapper();
        queryWrapper.eq(!StringUtils.isNotEmpty(employeeLeave.getLeaveReason()),"leave_reason","test")
        .eq(null !=employeeLeave.getLeaveType(),"leave_type",1)
        .orderByDesc("create_time");
        return employeeLeaveService.list(queryWrapper);
    }
    /**
     * @description: 自定义条件查
     * @author: 赖允翔
     * @date: 2020/6/15
     * @Param:
     * @return:
     */
    @RequestMapping("/c")
    public List<EmployeeLeave> getc(@RequestBody EmployeeLeave employeeLeave){
        QueryWrapper<EmployeeLeave> queryWrapper=new QueryWrapper();
        queryWrapper.eq(!StringUtils.isNotEmpty(employeeLeave.getLeaveReason()),"leave_reason","test")
                .eq(null !=employeeLeave.getLeaveType(),"leave_type",2)
                .orderByDesc("create_time");
        return employeeLeaveService.selectList1(queryWrapper);
    }
    /**
     * @description: 更新
     * @author: 赖允翔
     * @date: 2020/6/15
     * @Param:
     * @return:
     */
    @RequestMapping("/d")
    public String updated(@RequestBody EmployeeLeave employeeLeave){
        UpdateWrapper<EmployeeLeave> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",employeeLeave.getId())
                .eq(!StringUtils.isNotEmpty(employeeLeave.getLeaveReason()),"leave_reason","test");
        if (employeeLeaveService.update(updateWrapper)) {
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * @description: 插入
     * @author: 赖允翔
     * @date: 2020/6/15
     * @Param:
     * @return:
     */
    @RequestMapping("/e")
    public String adde(@RequestBody EmployeeLeave employeeLeave){
        if (employeeLeaveService.save(employeeLeave)) {
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * @description: 插入
     * @author: 赖允翔
     * @date: 2020/6/15
     * @Param:
     * @return:
     */
    @RequestMapping("/f")
    public String delf(@RequestBody EmployeeLeave employeeLeave) {
        if (employeeLeaveService.removeById(employeeLeave.getId())) {
            return "true";
        } else {
            return "false";
        }
    }

    /**
     * @description: ActiveRecord
     * @author: 赖允翔
     * @date: 2020/6/15
     * @Param:
     * @return:
     */
    @RequestMapping("/g")
    public String ActiveRecordg(@RequestBody EmployeeLeave employeeLeave) {
        if (employeeLeave.insert()) {
            return "true";
        } else {
            return "false";
        }
    }
}

