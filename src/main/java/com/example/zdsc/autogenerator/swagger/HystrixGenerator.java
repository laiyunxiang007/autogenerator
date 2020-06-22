package com.example.zdsc.autogenerator.swagger;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Model：
 * Description：
 * Author: 赖允翔
 * created：2020/6/15 14:25
 */
public class HystrixGenerator {
    public static void getHystrix() throws IOException {
        AutoGenerator mpg = new AutoGenerator();
        Properties p = new Properties();
        p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("code.properties"));
        String author = new String(p.getProperty("author").getBytes("UTF-8"), "utf-8");
        GlobalConfig gc = new GlobalConfig();
        String filepath = p.getProperty("path");
        gc.setOutputDir(filepath);
        gc.setAuthor(author);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setActiveRecord(true);
        gc.setOpen(false);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setFileOverride(true);
//        gc.setServiceName("%sService");
        gc.setControllerName(p.getProperty("classname")+"Service");
        gc.setEntityName(p.getProperty("classname"));
        mpg.setGlobalConfig(gc);
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(p.getProperty("url"));
        dsc.setDriverName(p.getProperty("driver"));
        dsc.setUsername(p.getProperty("username"));
        dsc.setPassword(p.getProperty("password"));
        mpg.setDataSource(dsc);
//        PackageConfig pc = new PackageConfig();
//        Map pathInfo = new HashMap();
//        pathInfo.put(ConstVal.CONTROLLER, filepath + "controller\\");
//        pathInfo.put(ConstVal.MAPPER, filepath + "mapper\\");
//        pathInfo.put(ConstVal.SERVICE, filepath + "service\\");
//        pathInfo.put(ConstVal.SERVICE_IMPL, filepath + "service\\");
//        pc.setPathInfo(pathInfo);
//        mpg.setPackageInfo(pc);
        InjectionConfig cfg = new InjectionConfig() {
            public void initMap() {
            }
        };
        List<FileOutConfig> focList = new ArrayList();
        String swservicePath = "/templates/SWhystrix.java.vm";
        focList.add(new FileOutConfig(swservicePath) {
            public String outputFile(TableInfo tableInfo) {
                return filepath + "swagger\\" + tableInfo.getEntityName() + "ServiceHystrix" + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setMapper(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setController(null);
        templateConfig.setService(null);
        templateConfig.setEntity(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(new String[]{"t_"});
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(p.getProperty("tablename"));
        strategy.setControllerMappingHyphenStyle(false);
        strategy.setSuperControllerClass(p.getProperty("classname")+"Service");
        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
