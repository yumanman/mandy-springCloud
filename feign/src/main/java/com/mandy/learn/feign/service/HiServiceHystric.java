package com.mandy.learn.feign.service;

import org.springframework.stereotype.Component;

/**
 * Title:  HiServiceHystric
 * Package com.mandy.learn.feign.service
 * Description:
 * Date:   2018/7/18 15:38
 *
 * @author mandy
 * @version V1.0
 */
@Component
public class HiServiceHystric implements HiService{
    @Override
    public String sayHi(String name) {
        return "sorry,"+name +" has error!";
    }
}
