package com.pluralsight.springboot.registration;

import com.pluralsight.springboot.events.Event;
import com.pluralsight.springboot.events.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/registrations")
public class RegistrationController {

    private final WebClient webClient;
    private final RegistrationRepository registrationRepository;

    public RegistrationController(WebClient webClient, RegistrationRepository registrationRepository) {
        this.webClient = webClient;
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration create(@RequestBody Registration registration) {
        Product product = webClient.get()
                .uri("/products/{id}",registration.productId())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
        Event event = webClient.get()
                .uri("/events/{id}",product.eventId())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(Event.class)
                .block();

        String ticketCode = UUID.randomUUID().toString();

        return registrationRepository.save(new Registration(
                null, registration.productId(),
                event.name(), product.price(),
                ticketCode, registration.attendeeName()));
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode) {
        return registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));
    }

    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        // Lookup the existing registration by ticket code
        String ticketCode = registration.ticketCode();
        var existing = registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));

        // Only update the attendee name
        return registrationRepository.save(new Registration(
                existing.id(), existing.productId(),
                existing.eventName(), existing.amount(),
                ticketCode, registration.attendeeName()));
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }
}
