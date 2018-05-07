package org.spring.springboot.repository;

import org.spring.springboot.domain.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * ES 操作类
 * <p>
 * Created by mongoding on 20/06/2017.
 */
public interface CityRepository extends ElasticsearchRepository<City, Long> {

}
