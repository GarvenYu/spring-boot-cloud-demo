package com.freesia.multidatasource.secondway.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author yukaibo
 * 动态数据源，根据策略返回具体的数据源
 * 当前策略为：加载线程上下文中的值
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceThreadLocal.getContextKey();
    }
}
