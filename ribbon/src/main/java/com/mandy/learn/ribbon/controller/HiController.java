package com.mandy.learn.ribbon.controller;

import com.mandy.learn.ribbon.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title:  HiController
 * Package com.mandy.learn.ribbon.controller
 * Description:
 * Date:   2018/7/18 15:08
 *
 * @author mandy
 * @version V1.0
 */
@RestController
public class HiController {
    @Autowired
    private HiService hiService;
    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String sayHello(){
       return "server:"+port+","+hiService.say("Root");
    }
}
