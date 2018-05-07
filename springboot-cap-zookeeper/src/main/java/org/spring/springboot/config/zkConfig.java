package org.spring.springboot.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.BoundedExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class zkConfig {


    @Autowired
    private org.spring.springboot.properties.zkConfigProperties zkConfigProperties;

    @Bean
    public CuratorFramework curatorFramework() {
        String url = zkConfigProperties.getUrl();
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(url, new BoundedExponentialBackoffRetry(1000, 8000, 4));
        curatorFramework.start();
        return curatorFramework;
    }
}
