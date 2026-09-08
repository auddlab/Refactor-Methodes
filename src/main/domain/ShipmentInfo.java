package main.domain;

import java.time.LocalDate;

public class ShipmentInfo {
    private final Planet origin;
    private final Planet destination;
    private final Ship ship;
    private final LocalDate departureDate;

    public ShipmentInfo(Planet origin, Planet destination, Ship ship, LocalDate departureDate){
        this.origin = origin;
        this.destination = destination;
        this.ship = ship;
        this.departureDate = departureDate;
    }

    public Planet getOrigin() { return origin; }
    public Planet getDestination() { return destination; }
    public Ship getShip() { return ship; }
    public LocalDate getDepartureDate() { return departureDate; }
}
