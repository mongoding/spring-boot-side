package org.spring.springboot.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain
            filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        //打印请求Url
        System.out.println("this is MyFilter,url :" + request.getRequestURI());
        filterChain.doFilter(srequest, sresponse);
    }

    @Override
    public void init(FilterConfig arg0) {
    }
}
