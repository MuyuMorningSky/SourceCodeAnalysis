package com.mayikt.config;

import com.mayikt.entity.UserEntity;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;

@ComponentScan(value = "com.mayikt", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)}, useDefaultFilters = true)
@Configuration
@EnableAsync
public class MySpringConfig {

    @Bean
    public UserEntity userEntity() {
        return new UserEntity("张三", 18);
    }

}
