package org.next.airxelerate.services;

import org.next.airxelerate.entities.Flight;

public interface FlightService {

    Flight add(Flight flight);

    Flight deleteById(Long id);

    Iterable<Flight> getAll();

    Flight update(Flight flight, long id);

    Flight getById(long id);

    Iterable<Flight> getAllByOriginAirportCode(String originAirportCode);

}