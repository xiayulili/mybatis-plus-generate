/*
 * Copyright(C),2019-2020,dream wind
 * FileName:MybatisPlusConfig.java
 * Author:xiayu
 * History:
 *    <author>  <time>  <version>  <desc>
 *      作者      修改时间      版本           描述
 */

package com.dream.xy.bootx.mybatisplusgenerate.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;



/**
 * <b>类描述:</b><br>
 * mybatis-plus配置类
 * 
 * @author xiayu
 * @version 1.0
 * @create 2019-08-12
 * @since 1.0.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.dream.xy.bootx.mybatisplusgenerate.**.mapper*")
public class MybatisPlusConfig {
	/**
	 * 
	 * <b>方法描述:/b><br>
	 * mybatis-plus SQL执行效率插件【生产环境可以关闭】
	 * 
	 * @return
	 * @author xiayu
	 * @date 2019-08-12
	 */
	@Bean
	@Profile({ "dev", "test" }) // 设置 dev test 环境开启
	public PerformanceInterceptor performanceInterceptor() {
		PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
		/* <!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 --> */
		// performanceInterceptor.setMaxTime(1000);
		/* <!--SQL是否格式化 默认false--> */
		// performanceInterceptor.setFormat(true);
		return performanceInterceptor;
	}

	/**
	 * 
	 * <b>方法描述:/b><br>
	 * mybatis-plus分页插件<br>
	 * 文档：http://mp.baomidou.com<br>
	 * 
	 * @return
	 * @author xiayu
	 * @date 2019-08-12
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		paginationInterceptor.setDialectType("mysql");
		return paginationInterceptor;
	}
}
