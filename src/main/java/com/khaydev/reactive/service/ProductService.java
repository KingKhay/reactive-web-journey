package com.khaydev.reactive.service;

import com.khaydev.reactive.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductService {

    public Flux<Product> getProducts() {
        Product product1 = new Product("P1");
        Product product2 = new Product("P2");

        return Flux.fromStream(Stream.of(product1, product2))
                .delayElements(Duration.ofSeconds(3));
    }
}
