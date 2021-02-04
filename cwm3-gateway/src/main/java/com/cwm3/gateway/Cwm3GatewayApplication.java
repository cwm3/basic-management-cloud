package com.cwm3.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关启动程序
 * 
 * @author cwm3
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Cwm3GatewayApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(Cwm3GatewayApplication.class, args);
        System.out.println( "网关启动成功! ");
    }
}
