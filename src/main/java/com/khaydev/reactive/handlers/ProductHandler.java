package com.khaydev.reactive.handlers;

import com.khaydev.reactive.model.Product;
import com.khaydev.reactive.service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class ProductHandler {

    private final ProductService productService;

    public ProductHandler(ProductService productService) {
        this.productService = productService;
    }

    public Mono<ServerResponse> getProducts(ServerRequest request){
        return ok().body(productService.getProducts(), Product.class);
    }
}
