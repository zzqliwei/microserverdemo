package com.westar;

import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

@Component
public class MyZuulFilter extends ZuulFilter {
    /**
     * pre post route error
     * pre 路由代理之前执行
     * route 代理的时候执行
     * error 出现错误的时候执行
     * post route或error执行完成之后再执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 链式调用 顺序 越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否使用过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("过滤器执行了");
        return null;
    }
}
