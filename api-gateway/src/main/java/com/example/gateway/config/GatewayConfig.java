package com.example.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service",p -> p
                          .path("/order/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("order-service")
                                .setFallbackUri("forward:/orderFallback")))
                        .uri("lb://ORDER-SERVICE"))
                .route("payment-service",p -> p
                        .path("/payment/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("payment-service")
                                .setFallbackUri("forward:/paymentFallback")))
                        .uri("lb://PAYMENT-SERVICE")).
                build();
    }
}
