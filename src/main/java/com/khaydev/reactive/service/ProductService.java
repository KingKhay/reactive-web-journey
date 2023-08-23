package com.khaydev.reactive.service;

import com.khaydev.reactive.model.Product;
import com.khaydev.reactive.subscriber.DemoSubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

@Service
public class ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public Flux<Product> getProducts() {
        Product product1 = new Product("P1");
        Product product2 = new Product("P2");

        demo();

        return Flux.fromStream(Stream.of(product1, product2))
                .delayElements(Duration.ofSeconds(3));
    }

    private void demo(){
        Integer[] nums = {1,2,3,4,5};
        Flux.fromArray(nums)
                .subscribe(new DemoSubscriber<Integer>());
    }
}
