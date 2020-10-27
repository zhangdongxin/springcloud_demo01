package com.offcn;

import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //开启注册中心的声明
public class EurekaServerStart {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerStart.class);
    }
}
