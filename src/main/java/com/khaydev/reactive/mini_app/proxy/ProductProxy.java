package com.khaydev.reactive.mini_app.proxy;

import com.khaydev.reactive.exception.OperationFailedException;
import com.khaydev.reactive.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class ProductProxy {

    private final Logger logger = LoggerFactory.getLogger(ProductProxy.class);
    private final WebClient webClient;

    public ProductProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Product> getAll(){
        return webClient.get()
                .exchangeToFlux(res -> res.bodyToFlux(Product.class))
                .onErrorMap(e -> new OperationFailedException()); // OnErrorMap maps the exception that occurs to a new exception
    }
    //                .onErrorResume(WebClientResponseException.class, Flux.just(new Product("Default Values"))) // OnErrorResume resumes the processing with a new flux when an error occurs
    //                .onErrorReturn(WebClientResponseException.class, new Product("Default")) // OnErrorReturn allows us to replace the error with single default value and complete the stream.
    //                .doOnNext(product -> {
    //                    if(product.getName() == null) throw new OperationFailedException();
    //                })
    //                .onErrorContinue(WebClientResponseException.class,(exception, event) -> logger.info(exception.getMessage())) //
    //                .retry(3)
}
