package com.stackroute;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Priyanshu Singh
 */
@Configuration
/*
Add configuration annotation
 */
public class GatewayConfig {

   /*
   * create a method to Route request to  http://localhost:8090 when /api/v1/** is hit
    */
    @Bean
    public RouteLocator customRoute(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes().route("blog",r -> r.path("/api/v1/**").uri("http://localhost:8090")).build();
    }
}

