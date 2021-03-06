package com.dream.mask.datasource.change;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mask")
public class DataSourceConfiguration {
    private HikariDataSource db1;
    private HikariDataSource db2;
}
