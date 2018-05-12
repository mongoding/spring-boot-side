package org.spring.springboot.business;


import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.service.INetPageDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * Created by mongoding on 2017/4/19.
 */
@Component
@Slf4j
public class NetPagerLookupBusiness {



    @Autowired
    private INetPageDownService netPageDownService;

    @Async("threadPoolTaskExecutor1")
    public Future<String> findByUrl(String url) throws InterruptedException {
        log.info("Looking up " + url);
        String results = netPageDownService.findByUrl(url);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        log.info("当前线程{}", Thread.currentThread().getName());
        return new AsyncResult<>(results);
    }

    @Async
    public void findDefaulByUrl() throws InterruptedException {
        findByUrl("http://www.baidu.com");

    }

    @Async
    public void findByUrlUnreturn(String url) throws InterruptedException {
        findByUrl(url);
    }

}