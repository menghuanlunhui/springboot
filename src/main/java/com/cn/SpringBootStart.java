package com.cn;

import com.cn.common.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chenyun
 * @projectName springboot
 * @description: SpringBoot启动类
 * @date 2019/8/30 13:49
 */
@EnableTransactionManagement //数据库表设置引擎为InnoDB 才支持事务,而MyISAM是不支持的
@SpringBootApplication
public class SpringBootStart  extends SpringBootServletInitializer {

    /**
     * tomcat启动时，运行该方法
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        LogManager.startup("TomcatStart");
        return application.sources(SpringBootStart.class);
    }

    /**
     * Springboot直接启动，运行该方法
     * @param args
     */
    public static void main(String[] args) {
        LogManager.startup("SpringBootStart");
        SpringApplication.run(SpringBootStart.class, args);
        System.out.println("*********    SpringBoot启动成功      *******ﾞ\n");
    }
}
