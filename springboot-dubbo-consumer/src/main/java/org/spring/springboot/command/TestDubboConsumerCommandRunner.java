package org.spring.springboot.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.spring.springboot.dubbo.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDubboConsumerCommandRunner implements CommandLineRunner{

    private static final Logger LOGGER = LoggerFactory.getLogger(TestDubboConsumerCommandRunner.class);
    @Autowired
    private CityDubboConsumerService cityDubboConsumerService;

    @Override
    public void run(String... args) throws Exception {

        String cityName = "河南";

        City city = cityDubboConsumerService.printCity(cityName);

        LOGGER.info("调用远程dubbo 服务，参数：{}，结果：{}",cityName,city);

    }
}
