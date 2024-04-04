package com.pluralsight.springboot.tickets.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface EventRepository extends JpaRepository<Event,Integer> {
//    private final List<Event> events = List.of(
//            new Event(501, "Globomantics Tech Conference",
//                    new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
//                    new Venue(201, "Globomatics Main Office", "Test Street 325", "New York", "USA"),
//                    LocalDate.of(2023, 10, 2), LocalDate.of(2023, 10, 4)),
//            new Event(502, "Globomantics Developer Day",
//                    new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
//                    new Venue(201, "Globomatics Main Office", "Test Street 325", "New York", "USA"),
//                    LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 10)),
//            new Event(503, "Carved Rock New Products Day",
//                    new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment"),
//                    new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "Los Angeles", "USA"),
//                    LocalDate.of(2024, 2, 29), LocalDate.of(2024, 2, 29))
//    );

    List<Event> findByOrganizerId(int organizerId);

//    public Optional<Event> findById(int id){
//        return events.stream().filter(event -> event.id() == id).findAny();
//    }
}
