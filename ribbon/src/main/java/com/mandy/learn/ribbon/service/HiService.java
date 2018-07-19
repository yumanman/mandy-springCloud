package com.mandy.learn.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Title:  HiService
 * Package com.mandy.learn.ribbon.service
 * Description:
 * Date:   2018/7/18 15:04
 *
 * @author mandy
 * @version V1.0
 */
@Service
public class HiService {
    @Autowired
    RestTemplate restTemplate;
    private static final String EUREKA_CLIENT_NAME="eureka-client";
    @HystrixCommand(fallbackMethod = "sayError")
    public String say(String name){
        return restTemplate.getForObject("http://"+EUREKA_CLIENT_NAME.toUpperCase()+"/hi?name="+name,String.class);
    }

    public String sayError(String name){
        return "hi,"+name +" has error!";
    }
}
