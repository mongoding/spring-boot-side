package org.spring.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(SingleDubboConfigBindingProperties.class)
public class CityDubboConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityDubboConfig.class);

    @Autowired
    private SingleDubboConfigBindingProperties dubboProperties;

    @Bean
    public Object getProperties(){
        LOGGER.info("dubbo 配置属性：{}",dubboProperties);
        return new Object();
    }

}
