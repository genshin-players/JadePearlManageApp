package cn.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 学社工作模块
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class WorkApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(WorkApp.class,args);
    }
}
