package org.spring.springboot.hytrix.config;

import com.alibaba.dubbo.common.URL;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
 * 线程池相关配置生成
 * Created by mongoding on 2018/2/28.
 */
public class HystrixThreadPoolPropertiesFactory {

    public static HystrixThreadPoolProperties.Setter create(URL url) {
        return HystrixThreadPoolProperties.Setter().withCoreSize(url.getParameter("coreSize", 10))

                //.withAllowMaximumSizeToDivergeFromCoreSize(true)
                //.withMaximumSize(url.getParameter("maximumSize", 20))
                .withMaxQueueSize(-1)
                .withKeepAliveTimeMinutes(url.getParameter("keepAliveTimeMinutes", 1));
    }
}
