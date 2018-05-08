package org.spring.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.City;
import org.spring.springboot.service.ICityDubboService;
import org.springframework.stereotype.Component;

/**
 * 城市业务 Dubbo 服务层实现层
 * <p>
 * Created by mongoding on 28/02/2017.
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
@Component
public class CityDubboServiceImpl implements ICityDubboService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityDubboServiceImpl.class);

    @Override
    public City findCityByName(String cityName) {
        return new City(1L, 2L, "河南", "是我的故乡");
    }
}
