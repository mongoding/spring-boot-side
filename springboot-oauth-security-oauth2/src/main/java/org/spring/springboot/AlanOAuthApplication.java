package org.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import java.util.Arrays;

/**
 * Created by mongoding() on 9/9/16.
 */
@SpringBootApplication
@EnableAuthorizationServer
public class AlanOAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlanOAuthApplication.class, args);
    }


    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(authenticationProvider));
    }

}
