package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class Airline {
    private int airline_code;
    private String airline_name;
    private List<Flight> airline_flightList = new ArrayList<>();

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
        airline_flightList.add(flight);
    }

    public void removeFlight(Flight flight) {
        airline_flightList.remove(flight);
    }

    public List<Flight> getAirline_flightList() {
        return airline_flightList;
    }
}
