package com.cwm3.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.cwm3.common.security.annotation.EnableRyFeignClients;

/**
 * 认证授权中心
 * 
 * @author cwm3
 */
@EnableRyFeignClients
@SpringCloudApplication
public class Cwm3AuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(Cwm3AuthApplication.class, args);
        System.out.println("认证授权中心启动成功!");
    }
}
