package org.spring.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.config.ext.CustomAsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@Slf4j
public class AsyncConfig extends AsyncConfigurerSupport {

    @Bean
    public ThreadPoolTaskExecutor asyncExecutor() {
        log.info("加载线程池配置：{}", "AsyncConfig.ThreadPoolTaskExecutor");
        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
        threadPool.setThreadNamePrefix("测试线程");
        threadPool.setCorePoolSize(3);
        threadPool.setMaxPoolSize(3);
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        threadPool.setAwaitTerminationSeconds(60 * 15);
        return threadPool;
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }
}
