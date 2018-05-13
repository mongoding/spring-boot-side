package org.spring.springboot.mvc.config;

import org.spring.springboot.mvc.converter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * All Rights Reserved !!!
 * <p>
 * WebMvcConfigurerAdapter(过时)
 */
@Configuration
@EnableWebMvc
@ComponentScan("org.spring.springboot.mvc")
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");

    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/converter").setViewName("/converter");
    }

    /**
     * 配置自定义的HttpMessageConverter 的Bean ，在Spring MVC 里注册HttpMessageConverter有两个方法：
     * 1、configureMessageConverters ：重载会覆盖掉Spring MVC 默认注册的多个HttpMessageConverter
     * 2、extendMessageConverters ：仅添加一个自定义的HttpMessageConverter ，不覆盖默认注册的HttpMessageConverter
     * 在这里重写extendMessageConverters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(converter());

    }

    @Bean
    public MyMessageConverter converter() {
        return new MyMessageConverter();
    }


}
