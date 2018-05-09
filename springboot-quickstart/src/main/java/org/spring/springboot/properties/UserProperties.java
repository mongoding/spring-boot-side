package org.spring.springboot.properties;

import org.spring.springboot.entity.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "org.spring.springboot.user")
@Component
public class UserProperties extends User {


}
