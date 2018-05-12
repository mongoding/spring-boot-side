package org.spring.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@Slf4j
public class OneThreadPoolConfig {

    @Bean
    public AsyncTaskExecutor taskExecutor() {
        log.info("加载OneThreadPoolConfig.taskExecutor 线程配置");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(10);
        executor.setThreadNamePrefix("OneThreadPoolConfig");
        return executor;
    }
}
