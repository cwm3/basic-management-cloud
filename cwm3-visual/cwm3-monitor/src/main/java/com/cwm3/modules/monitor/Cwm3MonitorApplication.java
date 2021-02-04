package com.cwm3.modules.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 监控中心
 * 
 * @author cwm3
 */
@EnableAdminServer
@SpringCloudApplication
public class Cwm3MonitorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(Cwm3MonitorApplication.class, args);
        System.out.println(" 监控中心启动成功 ");
    }
}
