package org.spring.springboot.upload.config;

import org.spring.springboot.upload.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class UploadConfig {

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
