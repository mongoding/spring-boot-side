package org.spring.springboot.servicegrid;

import org.apache.ignite.services.Service;

public interface WeatherService extends Service {
    /**
     * Get a current temperature for a specific city in the world.
     *
     * @param countryCode Country code (ISO 3166 country codes).
     * @param cityName    City name.
     * @return Current temperature in the city in JSON format.
     * @throws Exception if an exception happened.
     */
    String getCurrentTemperature(String countryCode, String cityName)
            throws Exception;
}
