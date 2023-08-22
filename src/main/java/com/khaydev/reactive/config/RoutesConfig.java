package com.khaydev.reactive.config;

import com.khaydev.reactive.handlers.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutesConfig {

    @Bean //Acts as the controller for the functional approach
    public RouterFunction<ServerResponse> router(ProductHandler productHandler){
        return route()
                .GET("/products", productHandler::getProducts)
                .build();
    }
}
