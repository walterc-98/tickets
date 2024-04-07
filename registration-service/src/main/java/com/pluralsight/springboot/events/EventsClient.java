package com.pluralsight.springboot.events;

import org.springframework.web.service.annotation.GetExchange;

public interface EventsClient {

    @GetExchange("/products/{id}")
    Product getProductById(int productId);

    @GetExchange("/events/{id}")
    Event getEventById(int eventId);
}
