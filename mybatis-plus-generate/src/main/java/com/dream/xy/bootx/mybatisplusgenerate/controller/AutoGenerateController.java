/*
 * Copyright(C),2019-2020,dream wind
 * FileName:AutoGenerateController.java
 * Author:xiayu
 * History:
 *    <author>  <time>  <version>  <desc>
 *      作者      修改时间      版本           描述
 */

package com.dream.xy.bootx.mybatisplusgenerate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <b>类描述:</b><br>
 * 代码自动生成controller层
 * 
 * @author xiayu
 * @version 1.0
 * @create 2019-08-12
 * @since 1.0.0
 */
@RestController
@RequestMapping("/code")
public class AutoGenerateController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private Environment env;

	@RequestMapping("/autogenerate")
	public String codeAutoGenerate(@RequestParam("tName") String tableName) {
		AutoGenerator mpg = new AutoGenerator();
		// 选择 freemarker 引擎，默认 Veloctiy
		// mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		// 获取当前工作目录
		String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setFileOverride(true);
		gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(true);// XML columList
		// gc.setKotlin(true);//是否生成 kotlin 代码
		gc.setAuthor("xiayu");
		mpg.setGlobalConfig(gc);

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setMapperName("%sMapper");
		//gc.setXmlName("%sMapper");
		gc.setServiceName("%sService");
		gc.setControllerName("%sController");
		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setDriverName(env.getProperty("spring.datasource.driverClassName"));
		dsc.setUrl(env.getProperty("spring.datasource.url"));
		dsc.setUsername(env.getProperty("spring.datasource.username"));
		dsc.setPassword(env.getProperty("spring.datasource.password"));
		mpg.setDataSource(dsc);
		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
		// strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 字段名生成策略
		strategy.setInclude(tableName.split(",")); // 需要生成的表
		strategy.setRestControllerStyle(true);
		// strategy.setExclude(new String[]{"test"}); // 排除生成的表
		// 自定义实体父类
		// strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
		// 自定义实体，公共字段
		// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
		// 自定义 mapper 父类
		// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
		// 自定义 service 父类
		// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
		// 自定义 service 实现类父类
		// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
		// 自定义 controller 父类
		// strategy.setSuperControllerClass("com.baomidou.demo.TestController");
		// 【实体】是否生成字段常量（默认 false）
		// public static final String ID = "test_id";
		strategy.setEntityColumnConstant(true);
		// 【实体】是否为构建者模型（默认 false）
		// public User setName(String name) {this.name = name; return this;}
		// strategy.setEntityBuilderModel(true);
		mpg.setStrategy(strategy);
		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("com.dream.xy.bootx.mybatisplusgenerate");
		pc.setController("controller");
		pc.setServiceImpl("service");
		pc.setService("service");
		pc.setMapper("mapper");
		pc.setEntity("pojo");
		pc.setXml("mapper");
		mpg.setPackageInfo(pc);
		// 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】 ${cfg.abc}
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
				this.setMap(map);
			}
		};
		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
		// 自定义配置会被优先输出
		String templatePath = "/templates/codegeneratetemplate/mapper.xml.vm";
		focList.add(new FileOutConfig(templatePath) {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper"
						+ StringPool.DOT_XML;
			}
		});
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 关闭默认 xml 生成，调整生成 至 根目录
		// TemplateConfig tc = new TemplateConfig();
		// tc.setXml(null);
		// mpg.setTemplate(tc);
		// 放置自己项目的 src/main/resources/templates 目录下, 默认名称以下可以不配置，也可以自定义模板名称
		TemplateConfig tc = new TemplateConfig();
		tc.setController("/templates/codegeneratetemplate/controller.java.vm");
		tc.setService("/templates/codegeneratetemplate/service.java.vm");
		tc.setServiceImpl("/templates/codegeneratetemplate/serviceimpl.java.vm");
		tc.setEntity("/templates/codegeneratetemplate/entity.java.vm");
		tc.setMapper("/templates/codegeneratetemplate/mapper.java.vm");
		tc.setXml(null); 
		// 如上任何一个模块如果设置 空 OR Null将不生成该模块。
		mpg.setTemplate(tc);
		// 执行生成
		mpg.execute();
		logger.debug("tableName:{}", tableName);
		return "success";
	}

}
