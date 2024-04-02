package com.pluralsight.springboot.tickets.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface VenueRepository extends JpaRepository<Venue,Integer> {
//    private final List<Venue> venues = List.of(
//            new Venue(201, "Globomatics Main Office", "Test Street 325", "New York", "USA"),
//            new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "Los Angeles", "USA")
//    );

//   public Optional<Venue> findById(int id){
//        return venues.stream().filter(venue -> venue.id() == id).findAny();
//    }
}
