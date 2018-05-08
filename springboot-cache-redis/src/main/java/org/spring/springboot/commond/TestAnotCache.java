package org.spring.springboot.commond;

import org.spring.springboot.domain.User;
import org.spring.springboot.service.INetPageDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(User.class)
@EnableCaching
public class TestAnotCache implements CommandLineRunner {

    @Autowired
    @Qualifier("annotCachePageDownService")
    private INetPageDownService netPageDownService;
    @Autowired
    private User user;

    @Override
    public void run(String... args) {
        String blogUrl = user.getBlogUrl();
        for (int i = 0; i < 10; i++) {
            netPageDownService.findByUrl(blogUrl);
        }
    }
}
