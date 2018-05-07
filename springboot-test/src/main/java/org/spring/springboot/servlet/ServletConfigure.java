package org.spring.springboot.servlet;

import org.spring.springboot.servlet.filter.MyFilter;
import org.spring.springboot.servlet.listener.IndexListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServletConfigure {

    /**
     * 代码注册servlet(不需要@ServletComponentScan注解)
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new MyServlet1(), "/servlet/myServlet1");// ServletName默认值为首字母小写，即myServlet1
    }

    /**
     * 多个servlet就注册多个bean
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean1() {
        return new ServletRegistrationBean(new MyServlet(), "/servlet/myServlet");// ServletName默认值为首字母小写，即myServlet
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());//添加过滤器
        registration.addUrlPatterns("/*");//设置过滤路径，/*所有路径
        registration.addInitParameter("name", "alue");//添加默认参数
        registration.setName("MyFilter");//设置优先级
        registration.setOrder(1);//设置优先级
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(new IndexListener());
        return servletListenerRegistrationBean;
    }


}