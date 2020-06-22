package com.example.zdsc.autogenerator;

import com.example.zdsc.CodeAutoGenerator;
import com.example.zdsc.autogenerator.swagger.HystrixGenerator;
import com.example.zdsc.autogenerator.swagger.SwaggerGenerator;

import java.io.IOException;

/**
 * Model：
 * Description：
 * Author: 赖允翔
 * created：2020/6/13 20:57
 */
public class CodeGenerator {
    public static void main(String[] args) throws IOException {
        CodeAutoGenerator.getServiceLayer();  //服务层
        AutoGeneratorVo.getVo();  //vo
        DTOGenerator.getDTO();   //dto
        //调用层
        SwaggerGenerator.getSwagger();
        HystrixGenerator.getHystrix();
    }
}
