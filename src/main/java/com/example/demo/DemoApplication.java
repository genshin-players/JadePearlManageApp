package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    //fzqsb
    public static void fzq(){
        System.out.println("fzqsb");
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        fzq();
    }

}
