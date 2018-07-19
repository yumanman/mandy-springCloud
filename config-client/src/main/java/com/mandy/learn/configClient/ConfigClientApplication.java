package com.mandy.learn.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:  ConfigClientApplication
 * Package com.mandy.learn.configClient
 * Description:
 * Date:   2018/7/18 17:32
 *
 * @author mandy
 * @version V1.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class,args);
    }

    /**
     * config client 中配置文件一定要boostrap命名
     */
    @Value("${foo}")
    String foo;

    @RequestMapping("/hi")
    public String say(){
        return foo;
    }
}
