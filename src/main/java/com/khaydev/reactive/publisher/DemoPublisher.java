package com.khaydev.reactive.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

public class DemoPublisher <T> implements Publisher<T> {

    private List<T> elements;

    @Override
    public void subscribe(Subscriber subscriber) {
        Subscription subscription = new Subscription() {

            private int lastRequestedElement = -1;
            @Override
            public void request(long l) {
                lastRequestedElement++;
                if(lastRequestedElement < elements.size()){
                    subscriber.onNext(elements.get(lastRequestedElement));
                }
                else {
                    subscriber.onComplete();
                }
            }

            @Override
            public void cancel() {

            }
        };

        subscriber.onSubscribe(subscription);
    }
}
