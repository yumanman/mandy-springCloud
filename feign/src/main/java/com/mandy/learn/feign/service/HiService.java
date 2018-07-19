package com.mandy.learn.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Title:  HiService
 * Package com.mandy.learn.feign.service
 * Description:    ${todo}
 * Date:   2018/7/18 15:23
 *
 * @author mandy
 * @version V1.0
 */
@FeignClient(value="eureka-client",fallback = HiServiceHystric.class)
public interface HiService {
    @RequestMapping("/hi")
    String sayHi(@RequestParam(value="name") String name);
}
