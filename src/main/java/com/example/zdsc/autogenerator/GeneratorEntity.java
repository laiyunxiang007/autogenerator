package com.example.zdsc.autogenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.IOException;
import java.util.*;

/**
 * Model：
 * Description：
 * Author: 赖允翔
 * created：2020/6/13 21:19
 */
public class GeneratorEntity {

    public static void getEntity() throws IOException {
        AutoGenerator mpg = new AutoGenerator();
        Properties p = new Properties();
        p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("code.properties"));
        GlobalConfig gc = new GlobalConfig();
        String filepath = p.getProperty("path");
        gc.setOutputDir(filepath);
        gc.setAuthor(p.getProperty("author"));
        gc.setActiveRecord(true);
        gc.setOpen(false);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setFileOverride(false);
        mpg.setGlobalConfig(gc);
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(p.getProperty("url"));
        dsc.setDriverName(p.getProperty("driver"));
        dsc.setUsername(p.getProperty("username"));
        dsc.setPassword(p.getProperty("password"));
        mpg.setDataSource(dsc);
//        PackageConfig pc = new PackageConfig();
//
//        Map pathInfo = new HashMap();
//        pathInfo.put(ConstVal.ENTITY, filepath+"entity");
//        pc.setPathInfo(pathInfo);
//        pc.setPathInfo(pathInfo);
//        mpg.setPackageInfo(pc);
        InjectionConfig cfg = new InjectionConfig() {
            public void initMap() {
            }
        };
        String templatePath = "/templates/entity.java.vm";
        List<FileOutConfig> focList = new ArrayList();
        focList.add(new FileOutConfig(templatePath) {
            public String outputFile(TableInfo tableInfo) {
                return filepath +"entity\\"+ tableInfo.getEntityName() + ".java";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setMapper(null);
        templateConfig.setController(null);
        templateConfig.setXml(null);
        templateConfig.setEntity(null);
        mpg.setTemplate(templateConfig);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(new String[]{"t_"});
        strategy.setEntityLombokModel(true);
        strategy.setInclude(p.getProperty("tablename"));
        strategy.setEntityTableFieldAnnotationEnable(true);
        mpg.setStrategy(strategy);
        mpg.execute();
    }


}
