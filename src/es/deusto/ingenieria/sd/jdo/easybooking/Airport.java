package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class Airport {
    @PrimaryKey
    private int airportCode;
    private String airportName;
    @Join
    @Persistent(mappedBy = "origin_airport", dependentElement = "false")
    private List<Plane> departingPlaneList = new ArrayList<>();
    @Join
    @Persistent(mappedBy = "destination_airport", dependentElement = "false")
    private List<Plane> arrivingPlaneList = new ArrayList<>();

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

    public void addDepartingPlane(Plane plane) {
        departingPlaneList.add(plane);
    }

    public void removeDepartingPlane(Plane plane) {
        departingPlaneList.remove(plane);
    }

    public List<Plane> getDepartingPlaneList() {
        return departingPlaneList;
    }

    public void addArrivingPlane(Plane plane) {
        arrivingPlaneList.add(plane);
    }

    public void removeArrivingPlane(Plane plane) {
        arrivingPlaneList.remove(plane);
    }

    public List<Plane> getArrivingPlaneList() {
        return arrivingPlaneList;
    }
}
