package org.spring.springboot.command;

import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.business.NetPagerLookupBusiness;
import org.spring.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.concurrent.Future;

/**
 * Created by mongoding on 2017/4/19.
 */
@Component
@EnableConfigurationProperties(User.class)
@Slf4j
public class AppRunner implements CommandLineRunner {


    private final NetPagerLookupBusiness netPagerLookupBusiness;

    @Autowired
    private User user;

    public AppRunner(NetPagerLookupBusiness netPagerLookupBusiness) {
        this.netPagerLookupBusiness = netPagerLookupBusiness;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("用户信息：{}", user);
        // Start the clock
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("任务一");

        // Kick of multiple, asynchronous lookups
        Future<String> page1 = netPagerLookupBusiness.findByUrl(user.getBlogUrl());
        stopWatch.stop();
        stopWatch.start("任务二");
        Future<String> page2 = netPagerLookupBusiness.findByUrl("http://www.jiuxian.com");
        stopWatch.stop();
        stopWatch.start("任务三");
        Future<String> page3 = netPagerLookupBusiness.findByUrl(user.getGithubUrl());
        stopWatch.stop();

        stopWatch.start("任务1，获取结果");

        String s1 = page1.get();
        stopWatch.stop();
        stopWatch.start("任务2，获取结果");
        String s2 = page1.get();
        stopWatch.stop();
        stopWatch.start("任务3，获取结果");
        String s3 = page1.get();
        stopWatch.stop();


        log.info(stopWatch.prettyPrint());

    }

}