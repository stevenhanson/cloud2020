package com.zdjc.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author flytiger
 * @since 2020-07-07 13:16
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_zdjc", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("path_route_zdjc", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }

}
