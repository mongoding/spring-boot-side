package org.spring.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ServletComponentScan
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
            System.out.println("benaName:" + beanDefinitionName);
        }
    }


}
