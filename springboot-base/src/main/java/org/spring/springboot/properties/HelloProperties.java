package org.spring.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * //@Component 如果这里添加了注解那么在自动配置类的时候就不用添加@enableConfigurationProperties(HelloProperties.class)注解.
 * <p>
 * 最主要的注解就是@enableAutoConfiguration,而这个注解会导入一个EnableAutoConfigurationImportSelector的类,而这个类会去读取一个spring.factories下key为EnableAutoConfiguration全限定名对应值.
 */
@ConfigurationProperties(prefix = "org.spring.springboot.hello")
@Component
public class HelloProperties {

    private String msg = "default";//现在我们在配置文件写hello.msg=world,因为简单就不再展示;如果那么默认为default.

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}