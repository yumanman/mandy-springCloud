package com.mandy.learn.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Title:  LoggerFilter
 * Package com.mandy.learn.zuul
 * Description:
 * Date:   2018/7/18 16:06
 *
 * @author mandy
 * @version V1.0
 */
@Component
public class LoggerFilter extends ZuulFilter {
    private Logger logger= LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    public String filterType() {
        //返回一个字符串，代表过滤类型
        /*
        * 1.pre 路由之前
        * 2.routing 路由时
        * 3.post    路由之后
        * 4.error   发生异常
        * */
        return "pre";
    }

    //filterOrder 过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("request>:method:{},uri:{},path:{},query:{}"+request.getMethod(),request.getRequestURI(),request.getServletPath(),request.getQueryString());
        return null;
    }
}
