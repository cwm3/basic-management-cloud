package com.cwm3.job;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.cwm3.common.security.annotation.EnableCustomConfig;
import com.cwm3.common.security.annotation.EnableRyFeignClients;
import com.cwm3.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 * 
 * @author cwm3
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringCloudApplication
public class Cwm3JobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(Cwm3JobApplication.class, args);
        System.out.println(" 定时任务模块启动成功 ");
    }
}
