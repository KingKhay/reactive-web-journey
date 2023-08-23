package com.khaydev.reactive.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoSubscriber <T> implements Subscriber<T> {

    private Subscription subscription;
    private final Logger logger = LoggerFactory.getLogger(DemoSubscriber.class);

    @Override
    public void onSubscribe(Subscription subscription) {
        logger.info("Subscribed to Publisher");
        this.subscription = subscription;
        subscription.request(1);
    }

    @Override
    public void onNext(T item) {
        logger.info("On Next Called ".concat(item.toString()));
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        //Publisher calls this method when an error occurs on its side
        logger.error("Error occurred on the Publisher");
    }

    @Override
    public void onComplete() {
        //Publisher calls this method when it has no more values to emit
        logger.info("On Complete called by Publisher");
    }
}
