package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class Airport {
    private int airportCode;
    private String airportName;
    private List<Flight> flightList = new ArrayList<>();

    public Airport(int airportCode, String airportName) {
        this.airportCode = airportCode;
        this.airportName = airportName;
    }

    public int getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(int airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
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
