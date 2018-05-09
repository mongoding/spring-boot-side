package org.spring.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class) 部分自动配置无效
 * @SpringBootApplication = @EnableAutoConfiguration + @ComponentScan + @Configuration
 * 默认开启了
 * <p>
 * DispatcherServletAutoConfiguration 注册DispatcherServlet
 * EmbeddedServletContainerAutoConfiguration.EmbeddedTomcat 注册Tomcat容器
 * ErrorMvcAutoConfiguration 注册异常处理器
 * HttpEncodingAutoConfiguration 注册编码过滤器CharacterEncodingFilter
 * HttpMessageConvertersAutoConfiguration 注册json或者xml处理器
 * JacksonAutoConfiguration 注册json对象解析器
 * MultipartAutoConfiguration 注册文件传输处理器
 * TransactionAutoConfiguration 注册事物管理处理器
 * ValidationAutoConfiguration 注册数据校验处理器
 * WebMvcAutoConfiguration 注册SpringMvc相关处理器
 */
@SpringBootApplication
//@ComponentScan
public class SpringbootApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootApplication.class);


    public static void main(String[] args) {


        System.out.println("主线程start：" + Thread.currentThread().getName());
        ApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);
        System.out.println("主线程：" + Thread.currentThread().getName());

		/*SpringApplication springApplication = new SpringApplication();
		Resource resource = new ClassPathResource("test-banner.gif");
		Banner banner = new ImageBanner(resource);
		springApplication.setBanner(banner);*/


		/*TestApplicationListener1 testApplicationListener1 = new TestApplicationListener1;
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder()
				.listeners(testApplicationListener1)
				.build()
				.run(args);*/
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //System.out.println("beanDefinitionName:" + beanDefinitionName);
        }
    }


}
