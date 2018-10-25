package es.deusto.ingenieria.sd.jdo.easybooking;

import java.util.ArrayList;
import java.util.List;

public class Plane {
    private Airline airline;
    private int plane_code;
    private Airport origin_airport;
    private Airport destination_airport;
    private int total_seats;
    private List<Flight> flightList = new ArrayList<>();

    public Plane(Airline airline, int plane_code, Airport origin_airport, Airport destination_airport, int total_seats) {
        this.airline = airline;
        this.plane_code = plane_code;
        this.origin_airport = origin_airport;
        this.destination_airport = destination_airport;
        this.total_seats = total_seats;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getPlane_code() {
        return plane_code;
    }

    public void setPlane_code(int plane_code) {
        this.plane_code = plane_code;
    }

    public Airport getOrigin_airport() {
        return origin_airport;
    }

    public void setOrigin_airport(Airport origin_airport) {
        this.origin_airport = origin_airport;
    }

    public Airport getDestination_airport() {
        return destination_airport;
    }

    public void setDestination_airport(Airport destination_airport) {
        this.destination_airport = destination_airport;
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public void addFlight(Flight flight) {
        flightList.add(flight);
    }

    public void removeFlight(Flight flight) {
        flightList.remove(flight);
    }

    public List<Flight> getFlightList() {
        return flightList;
    }
}
