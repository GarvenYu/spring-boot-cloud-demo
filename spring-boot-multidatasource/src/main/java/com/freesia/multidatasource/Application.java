package com.freesia.multidatasource;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author freesia <yukaibo@bytedance.com>
 * @date 2020-01-11 18:07
 **/
@SpringBootApplication(exclude = {MybatisAutoConfiguration.class})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
