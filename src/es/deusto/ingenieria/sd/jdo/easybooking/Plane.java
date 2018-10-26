package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class Plane {
    @PrimaryKey
    private int plane_code;
    private Airport origin_airport;
    private Airport destination_airport;
    private int total_seats;
    @Join
    private List<Flight> flightList = new ArrayList<>();

    public Plane(int plane_code, Airport origin_airport, Airport destination_airport, int total_seats) {
        this.plane_code = plane_code;
        this.origin_airport = origin_airport;
        this.destination_airport = destination_airport;
        this.total_seats = total_seats;

        origin_airport.addDepartingPlane(this);
        destination_airport.addArrivingPlane(this);
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
