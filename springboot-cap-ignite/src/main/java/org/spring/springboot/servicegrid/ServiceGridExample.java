package org.spring.springboot.servicegrid;

import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ServiceGridExample {

    @Autowired
    private Ignite ignite;

    public void runServiceGrid() {
        // Deploying a single instance of the Weather Service
        // in the whole cluster.
        try {
            ignite.services().deployClusterSingleton("WeatherService",
                    new WeatherServiceImpl());
            // Requesting current weather for London.
            WeatherService service = ignite.services().service("WeatherService");
            String forecast = service.getCurrentTemperature("London", "UK");
            System.out.println("Weather forecast in London:" + forecast);
        } catch (Exception e) {
            log.error("error", e);
        }

    }
}
