package com.cwm3.system;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.cwm3.common.security.annotation.EnableCustomConfig;
import com.cwm3.common.security.annotation.EnableRyFeignClients;
import com.cwm3.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 * 
 * @author cwm3
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class Cwm3SystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(Cwm3SystemApplication.class, args);
        System.out.println("系统模块启动成功" );
    }
}