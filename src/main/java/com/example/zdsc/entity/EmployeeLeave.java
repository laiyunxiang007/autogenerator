package com.example.zdsc.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 *
 * 员工离职信息表
 *
 *
 * @author 赖允翔
 * @since 2020-06-15
 */
@Data
@TableName("t_employee_leave")
public class EmployeeLeave extends Model<EmployeeLeave> {

private static final long serialVersionUID=1L;

/**
* 主键id
*/
@TableId(value = "id" , type = IdType.AUTO)
private Integer id;

/**
* 机构id
*/
@TableField("organization_id")
private Integer organizationId;

/**
* 员工id
*/
@TableField("employee_id")
private String employeeId;

/**
* 入职日期
*/
@TableField(value = "entry_date")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GTM+8")
private Date entryDate;

/**
* 离职类型 1:主动离职 2:被动离职（辞退） 3:调出
*/
@TableField("leave_type")
private Integer leaveType;

/**
* 离职日期
*/
@TableField(value = "leave_date",fill = FieldFill.INSERT)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GTM+8")
private Date leaveDate;

/**
* 离职原因
*/
@TableField("leave_reason")
private String leaveReason;

/**
* 剩余年假（天）
*/
@TableField("residual_annual_leave")
private BigDecimal residualAnnualLeave;

/**
* 年假处理方式  1：计算工资  2：调休
*/
@TableField("annual_leave_handle")
private Integer annualLeaveHandle;

/**
* 加班时长（小时，带小数点）
*/
@TableField("overtime_hours")
private BigDecimal overtimeHours;

/**
* 加班时长处理  1：计算工资  2：调休
*/
@TableField("overtime_hours_handle")
private Integer overtimeHoursHandle;

/**
* 补偿金额
*/
@TableField("compensation_amount")
private BigDecimal compensationAmount;

/**
* 创建人用户id
*/
@TableField("create_user_id")
private Integer createUserId;

/**
* 创建时间
*/
@TableField(value = "create_time",fill = FieldFill.INSERT)
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GTM+8")
private Date createTime;




@Override
protected Serializable pkVal(){
            return this.id;
        }

        }
