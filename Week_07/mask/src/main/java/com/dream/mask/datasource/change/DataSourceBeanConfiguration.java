package com.dream.mask.datasource.change;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceBeanConfiguration {
    
    @Autowired
    private DataSourceConfiguration dataSourceConfiguration;
    
    @Bean
    public DataSource dataSource(){
        Map<Object,Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("db1",dataSourceConfiguration.getDb1());
        dataSourceMap.put("db2",dataSourceConfiguration.getDb2());
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        dynamicDataSource.setDefaultTargetDataSource(dataSourceConfiguration.getDb1());
        return dynamicDataSource;
    }
}
