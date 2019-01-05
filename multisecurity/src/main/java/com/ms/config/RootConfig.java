package com.ms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistenceConfig.class})

@ComponentScan(basePackages="com.ms.dao")
public class RootConfig {

}
