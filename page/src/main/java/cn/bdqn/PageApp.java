package cn.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PageApp {
    public static void main(String[] args) {
        SpringApplication.run(PageApp.class, args);
    }
}
