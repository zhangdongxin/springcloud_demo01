package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients    //开启Feign功能
@EnableCircuitBreaker //开启断路保护功能
@EnableHystrixDashboard //开启可视化监控功能
public class ConsumerUserFeign {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserFeign.class);
    }
}
