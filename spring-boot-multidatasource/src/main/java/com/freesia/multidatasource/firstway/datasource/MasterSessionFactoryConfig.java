package com.freesia.multidatasource.firstway.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * @author yukaibo
 */
@Configuration
@MapperScan(basePackages = "com.freesia.multidatasource.firstway.mapper.master", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterSessionFactoryConfig {

    @Bean
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        // 设置数据源
        SqlSessionFactoryBean mybatisSqlSessionFactoryBean = new SqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        //mapper的xml文件位置
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        String locationPattern = "classpath*:/mapper/master/*.xml";
//        mybatisSqlSessionFactoryBean.setMapperLocations(resolver.getResources(locationPattern));
        //对应数据库的entity位置
//        String typeAliasesPackage = "me.mason.demo.basicmultidatasource.entity.master";
//        mybatisSqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        mybatisSqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return mybatisSqlSessionFactoryBean.getObject();
    }
}
