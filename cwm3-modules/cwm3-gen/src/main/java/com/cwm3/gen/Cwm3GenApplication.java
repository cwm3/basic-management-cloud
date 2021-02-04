package com.cwm3.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.cwm3.common.security.annotation.EnableCustomConfig;
import com.cwm3.common.security.annotation.EnableRyFeignClients;
import com.cwm3.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 * 
 * @author cwm3
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringCloudApplication
public class Cwm3GenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(Cwm3GenApplication.class, args);
        System.out.println("  代码生成模块启动成功 !");
    }
}
