package org.spring.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@Slf4j
public class MultThreadPoolConfig {


    @Bean(name = "threadPoolTaskExecutor1")
    public Executor threadPoolTaskExecutor1() {
        log.info("加载{}配置;MultThreadPoolConfig.threadPoolTaskExecutor1");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("threadPoolTaskExecutor1");
        return threadPoolTaskExecutor;
    }

    @Bean(name = "threadPoolTaskExecutor2")
    public Executor threadPoolTaskExecutor2() {
        log.info("加载{}配置;MultThreadPoolConfig.threadPoolTaskExecutor2");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("threadPoolTaskExecutor2");
        return threadPoolTaskExecutor;
    }
}
