package org.next.airxelerate.services.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.next.airxelerate.entities.Flight;
import org.next.airxelerate.exceptions.FlightNotFoundException;
import org.next.airxelerate.exceptions.IataCarrierCodeException;
import org.next.airxelerate.repositories.FlightRepository;
import org.next.airxelerate.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight add(Flight flight) {
        log.info("add new flight: " + flight);
        return flightRepository.save(flight);
    }

    @Override
    public Flight deleteById(Long id) {
        log.info("delete flight with id: " + id);
        Optional<Flight> flightToDelete = flightRepository.findById(id);
        if (flightToDelete.isPresent()) {
            flightRepository.deleteById(id);
            return flightToDelete.get();
        } else {
            throw new FlightNotFoundException(id);
        }
    }

    @Override
    public Iterable<Flight> getAll() {
        log.info("get all flights");
        return flightRepository.findAll();
    }

    @Override
    public Flight update(Flight flight, long flightId) {
        Flight oldFlight = flightRepository.findById(flightId).orElseThrow(() -> new FlightNotFoundException(flightId));
        if (flight.getIataCarrierCode().equals(oldFlight.getIataCarrierCode())){
            oldFlight.setDepartureDate(flight.getDepartureDate());
            oldFlight.setOriginAirportCode(flight.getOriginAirportCode());
            oldFlight.setDestinationAirportCode(flight.getDestinationAirportCode());
            oldFlight.setNumber(flight.getNumber());
            flightRepository.save(oldFlight);
        } else {
            throw new IataCarrierCodeException("IATA code missing, please verify your code or call the support");
        }
        return oldFlight;
    }

    @Override
    public Flight getById(long flightId) {
        log.info("get flight by id: " + flightId);
        return flightRepository.findById(flightId).orElseThrow(() -> new FlightNotFoundException(flightId));
    }

    @Override
    public Iterable<Flight> getAllByOriginAirportCode(String originAirportCode) {
        log.info("get flights by originAirportCode: " + originAirportCode);
        return flightRepository.findByOriginAirportCode(originAirportCode);
    }
}