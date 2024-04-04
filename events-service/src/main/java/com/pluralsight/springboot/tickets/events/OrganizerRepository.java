package com.pluralsight.springboot.tickets.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {
//    private final List<Organizer> organizers = List.of(
//            new Organizer(101, "Globomantics", "Globomantics Technology Corporation"),
//            new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment")
//    );

    //public List<Organizer> findAll();
}
