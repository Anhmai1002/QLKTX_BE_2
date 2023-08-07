package com.example.hochtmlbackend;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Collections;

@SpringBootApplication
@EnableMongoAuditing
@EnableAsync
public class HochtmlbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(HochtmlbackendApplication.class, args);
    }

    @Bean
    DozerBeanMapper mapper() {
        DozerBeanMapper beanMapper = new DozerBeanMapper();

        beanMapper.setMappingFiles(Collections.singletonList("dozerJdk8Converters.xml"));

        return beanMapper;
    }

}
