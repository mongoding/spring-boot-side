package org.spring.springboot.redis.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.service.INetPageDownService;
import org.spring.springboot.service.impl.NetPageDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Service
public class CachePageDownService implements INetPageDownService {
    private static final Logger logger = LoggerFactory.getLogger(NetPageDownService.class);

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private INetPageDownService netPageDownService;

    @Override
    public String findByUrl(String url) {
        String key = url;
        ValueOperations<String, String> ops = template.opsForValue();
        String content = ops.get(key);
        if (!StringUtils.isEmpty(content)) {
            logger.info("请求url：{},缓存中存在", url);
            return content;
        }
        content = netPageDownService.findByUrl(url);
        ops.set(key, content, 1, TimeUnit.MINUTES);//1分钟过期

        return content;
    }
}
