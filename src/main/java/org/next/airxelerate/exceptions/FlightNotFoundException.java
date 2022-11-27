package org.next.airxelerate.exceptions;

public class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(Long id) {
        super("flight with id:" + id + " was not found");
    }
}
