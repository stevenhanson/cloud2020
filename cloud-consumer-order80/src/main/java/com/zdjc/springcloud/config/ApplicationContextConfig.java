package com.zdjc.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author flytiger
 * @since 2020-06-27 9:32
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
