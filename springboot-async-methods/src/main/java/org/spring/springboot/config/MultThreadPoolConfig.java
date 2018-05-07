package org.spring.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class MultThreadPoolConfig {

    private static final Logger logger = LoggerFactory.getLogger(MultThreadPoolConfig.class);

    @Bean(name = "threadPoolTaskExecutor1")
    public Executor threadPoolTaskExecutor1() {
        logger.info("加载{}配置;MultThreadPoolConfig.threadPoolTaskExecutor1");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("threadPoolTaskExecutor1");
        return threadPoolTaskExecutor;
    }

    @Bean(name = "threadPoolTaskExecutor2")
    public Executor threadPoolTaskExecutor2() {
        logger.info("加载{}配置;MultThreadPoolConfig.threadPoolTaskExecutor2");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("threadPoolTaskExecutor2");
        return threadPoolTaskExecutor;
    }
}
