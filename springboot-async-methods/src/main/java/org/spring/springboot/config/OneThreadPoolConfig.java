package org.spring.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class OneThreadPoolConfig {
    private static final Logger logger = LoggerFactory.getLogger(OneThreadPoolConfig.class);

    @Bean
    public AsyncTaskExecutor taskExecutor() {
        logger.info("加载OneThreadPoolConfig.taskExecutor 线程配置");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(10);
        executor.setThreadNamePrefix("OneThreadPoolConfig");
        return executor;
    }
}
