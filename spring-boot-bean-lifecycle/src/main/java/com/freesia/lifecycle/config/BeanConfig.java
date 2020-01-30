package com.freesia.lifecycle.config;

import com.freesia.lifecycle.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yukaibo
 * */
@Configuration
public class BeanConfig {

    @Bean(initMethod = "carInitMethod", destroyMethod = "carDestroyMethod")
    public Car car(){
        Car car = new Car();
        car.setBand("BMW");
        return car;
    }
}
