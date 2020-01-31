package com.freesia.multidatasource;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author freesia <yukaibo@bytedance.com>
 * @date 2020-01-11 18:07
 **/
//使用方式1时，不能允许MybatisAutoConfiguration自动装配
//@SpringBootApplication(exclude = {MybatisAutoConfiguration.class})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
