package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class Airline {
    @PrimaryKey
    private int airline_code;
    private String airline_name;
    @Join
    @Persistent(mappedBy = "airline", dependentElement = "false")
    private List<Flight> flightList = new ArrayList<>();

    public Airline(int airline_code, String airline_name) {
        this.airline_code = airline_code;
        this.airline_name = airline_name;
    }

    public int getAirline_code() {
        return airline_code;
    }

    public void setAirline_code(int airline_code) {
        this.airline_code = airline_code;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
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
