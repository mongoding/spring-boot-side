package org.spring.springboot.command;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IgniteCacheComandRunner implements CommandLineRunner {

    @Autowired
    private Ignite ignite;

    @Override
    public void run(String... args) {
        IgniteCache<Object, Object> cache = ignite.cache("test-ignite");
        cache.put("name", "mongoding");
    }
}
