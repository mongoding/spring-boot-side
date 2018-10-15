package org.spring.springboot.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 城市 Dubbo 服务消费者
 * <p>
 * Created by mongoding on 28/02/2017.
 */
@Component
public class CityDubboConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityDubboConsumerService.class);

    @Reference(version = "1.0.0")
    org.spring.springboot.service.ICityDubboService cityDubboService;

    public City printCity(String cityName) {
        City city = cityDubboService.findCityByName(cityName);
        LOGGER.info("调用远程dubbo 服务，参数：{}，结果：{}",cityName,city);
        return city;
    }
}
