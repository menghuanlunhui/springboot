package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chenyun
 * @projectName springboot
 * @description: SpringBoot启动类
 * @date 2019/8/30 13:49
 */
@EnableTransactionManagement
@SpringBootApplication
public class SpringBootStart {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStart.class, args);
        System.out.println("*********    SpringBoot启动成功      *******ﾞ\n");
    }
}
