package org.next.airxelerate.controllers;

import jakarta.validation.Valid;
import org.next.airxelerate.entities.Flight;
import org.next.airxelerate.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/{flightId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Flight getById(final @PathVariable int flightId) {
        return flightService.getById(flightId);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Iterable<Flight> getAll() {
        return flightService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, params = {"originAirportCode"})
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Iterable<Flight> getAllByOriginAirportCode(@RequestParam String originAirportCode) {
        return flightService.getAllByOriginAirportCode(originAirportCode);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Flight addNewFlight(@RequestBody @Valid final Flight flight) {
        return flightService.add(flight);
    }

    @RequestMapping(value = "/{flightId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Flight modify(@RequestBody @Valid final Flight flight, final @PathVariable int flightId) {
        return flightService.update(flight, flightId);
    }

    @RequestMapping(value = "/{flightId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Flight delete(final @PathVariable long flightId) {
        return flightService.deleteById(flightId);
    }
}
