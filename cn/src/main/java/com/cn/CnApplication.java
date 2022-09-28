package com.cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
@MapperScan("com.cn.dao")
public class CnApplication {
    public static void main(String[] args) {
//        String[] arg=new String[1];
//        arg[0]="--server.port=8084";
        SpringApplication.run(CnApplication.class, args);
        System.out.println("1");
        System.out.println("3");
        System.out.println("4");
    }

}
