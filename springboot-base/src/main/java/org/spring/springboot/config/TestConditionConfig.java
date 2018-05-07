package org.spring.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.SpringbootApplication;
import org.spring.springboot.conditional.MyConditionA;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


/**
 * @ConditionalOnClass ： classpath中存在该类时起效
 * @ConditionalOnMissingClass ： classpath中不存在该类时起效
 * @ConditionalOnBean ： DI容器中存在该类型Bean时起效
 * @ConditionalOnMissingBean ： DI容器中不存在该类型Bean时起效
 * @ConditionalOnSingleCandidate ： DI容器中该类型Bean只有一个或@Primary的只有一个时起效
 * @ConditionalOnExpression ： SpEL表达式结果为true时
 * @ConditionalOnProperty ： 参数设置或者值一致时起效
 * @ConditionalOnResource ： 指定的文件存在时起效
 * @ConditionalOnJndi ： 指定的JNDI存在时起效
 * @ConditionalOnJava ： 指定的Java版本存在时起效
 * @ConditionalOnWebApplication ： Web应用环境下起效
 * @ConditionalOnNotWebApplication ： 非Web应用环境下起效
 */
@Configuration

public class TestConditionConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootApplication.class);

    public TestConditionConfig() {
        System.out.println("ConditionAnnotationConfig is init $$$$$$$$$$$$$$");
    }

    @Bean("obj1")
    @Conditional(MyConditionA.class)
    public Object testCondition1() {
        System.out.println("MyConditionA 返回ture了");
        LOGGER.info("TestConditionConfig.testCondition1 running");
        return new Object();
    }

    @Bean("obj2")
    @ConditionalOnClass(MyConditionA.class)
    public Object testCondition2() {
        System.out.println("ConditionalOnClass测试是否存在某个类");
        return new Object();
    }

    @Bean("obj3")
    @ConditionalOnMissingClass("org.spring.springboot.AA")
    public Object testCondition3() {
        System.out.println("ConditionalOnMissingClass测试是否缺失某个类");
        return new Object();
    }

    @Bean("obj4")
    @ConditionalOnMissingBean(MyConditionA.class)
    public Object testCondition4() {
        System.out.println("ConditionalOnMissingBean测试时否缺失某个bean");
        return new Object();
    }

    @Bean("obj5")
    @ConditionalOnBean(MyConditionA.class)
    public Object testCondition5() {
        System.out.println("ConditionalOnBean测试是否存在某个bean");
        return new Object();
    }

    @Bean("obj1")
    @ConditionalOnCloudPlatform(CloudPlatform.SAP)
    public Object testCondition6() {
        System.out.println("测试ConditionalOnCloudPlatform");
        return new Object();
    }

    @Bean("obj1")
    @ConditionalOnExpression("true")
    public Object testCondition7() {
        System.out.println("测试ConditionalOnExpression");
        return new Object();
    }

    @Bean("obj1")
    @ConditionalOnJava(value = JavaVersion.NINE)
    public Object testCondition8() {
        System.out.println("测试ConditionalOnJava");
        return new Object();
    }

    @Bean("obj1")
    @ConditionalOnWebApplication()
    public Object testCondition9() {
        System.out.println("测试ConditionalOnWebApplication");
        return new Object();
    }

    @Bean("obj1")
    @ConditionalOnProperty("cache.switch")
    public Object testCondition10() {
        System.out.println("测试ConditionalOnProperty");
        return new Object();
    }

    @Bean("obj11")
    @ConditionalOnResource(resources = "spring.xml")
    public Object testCondition11() {
        System.out.println("测试ConditionalOnResource");
        return new Object();
    }


}