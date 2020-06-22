package com.example.zdsc.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Model：mybatis plus配置类
 * Description：
 * Author: 赖允翔
 * created：2020/6/15 10:01
 */
@Component
public class MyBatisPlusConfig implements MetaObjectHandler {
    Log log = LogFactory.getLog(MyBatisPlusConfig.class);
    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

     /**
      * @description: 自动填充
      * @author: 赖允翔
      * @date: 2020/6/16
      * @Param:
      * @return:
      */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.setFieldValByName("createTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update insert fill ....");
    }
}
