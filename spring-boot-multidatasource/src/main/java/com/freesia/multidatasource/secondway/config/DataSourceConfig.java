package com.freesia.multidatasource.secondway.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yukaibo
 * 创建主从两个静态的测试数据源
 * 创建动态数据源整合多个静态数据源
 * 具体加载哪个数据源由determineCurrentLookupKey决定
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@MapperScan(basePackages = "com.freesia.multidatasource.secondway.mapper")
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.master2")
    public DataSourceProperties masterDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave2")
    public DataSourceProperties slaveDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource masterStaticDataSource() {
        return masterDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public DataSource slaveStaticDataSource() {
        return slaveDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    public DataSource dynamicDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        //key=String, value=DataSource
        dataSourceMap.put(DataSourceConstants.DS_KEY_MASTER, masterStaticDataSource());
        dataSourceMap.put(DataSourceConstants.DS_KEY_SLAVE, slaveStaticDataSource());
        //设置动态数据源
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(masterStaticDataSource());

        return dynamicDataSource;
    }

}
