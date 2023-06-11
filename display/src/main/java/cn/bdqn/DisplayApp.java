package cn.bdqn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ZedFeorius
 * @version 1.0.0
 * @date 06 10 2023  19:55:01
 * @packageName cn.bdqn
 * @className DisplayApp
 * @describe TODO
 */
@EnableEurekaClient
@SpringBootApplication
public class DisplayApp {
    public static void main(String[] args) {
        SpringApplication.run(DisplayApp.class,args);
    }
}
