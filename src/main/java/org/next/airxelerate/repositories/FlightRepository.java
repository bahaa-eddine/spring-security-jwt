package org.next.airxelerate.repositories;

import org.next.airxelerate.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Iterable<Flight> findByOriginAirportCode(String originAirportCode);
}