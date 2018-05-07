package org.spring.springboot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final NetPagerLookupBusiness netPagerLookupBusiness;

    @Autowired
    private User user;

    public AppRunner(NetPagerLookupBusiness netPagerLookupBusiness) {
        this.netPagerLookupBusiness = netPagerLookupBusiness;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("用户信息：{}", user);
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


        logger.info(stopWatch.prettyPrint());

    }

}