package com.example.zdsc.autogenerator;

import com.baomidou.mybatisplus.annotation.DbType;
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
 * created：2020/6/13 20:59
 */
public class DTOGenerator {
    public static void getDTO() throws IOException {

        AutoGenerator mpg = new AutoGenerator();
        Properties p = new Properties();
        p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("code.properties"));
        String author = new String(p.getProperty("author").getBytes("utf-8"), "utf-8");
        GlobalConfig gc = new GlobalConfig();
        final String filepath = p.getProperty("path");
        gc.setOutputDir(filepath);
        gc.setAuthor(author);
        gc.setFileOverride(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setEntityName("%sDTO");
        gc.setOpen(true);
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
//        pathInfo.put(ConstVal.ENTITY, filepath+"dto");
//        pc.setPathInfo(pathInfo);
//        mpg.setPackageInfo(pc);
        InjectionConfig cfg = new InjectionConfig() {
            public void initMap() {
            }
        };
        String templatePath = "/templates/entityDTO.java.vm";
        List<FileOutConfig> focList = new ArrayList();
        focList.add(new FileOutConfig(templatePath) {
            public String outputFile(TableInfo tableInfo) {
                tableInfo.setName(p.getProperty("classname"));
                return filepath+"dto\\" + tableInfo.getEntityName() + ".java";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity((String)null);
        templateConfig.setService((String)null);
        templateConfig.setServiceImpl((String)null);
        templateConfig.setMapper((String)null);
        templateConfig.setController((String)null);
        templateConfig.setXml((String)null);
        mpg.setTemplate(templateConfig);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix(new String[]{"t_"});
        strategy.setEntityLombokModel(true);
        strategy.setInclude(p.getProperty("tablename").split(","));
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
