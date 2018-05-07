package org.spring.springboot.service;


/**
 * @Component 这里很重要，如果我们添加了这个注解那么，按照我们下面的设置SpringBoot会优先使用我们配置的这个Bean，这是符合SpringBoot框架优先使用自定义Bean的原则的。
 */
//@Component
public class HelloService {

    private String msg = "service";//如果自动配置没有读入成功，那么为默认值

    public String say() {
        return "hello " + msg;
    }//为我们服务的方法

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}