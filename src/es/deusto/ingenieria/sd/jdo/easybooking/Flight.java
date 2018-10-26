package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@PersistenceCapable
public class Flight {
    @PrimaryKey
    private int flight_code;
    private Plane plane;
    private Airline airline;
    private Date arrival_time;
    private Date arrival_date;
    private Date departure_time;
    private Date departure_date;
    private int remaining_seats;
    private List<Reservation> reservationList = new ArrayList<>();


    public Flight(Airline airline, Plane plane, int flight_code, Date arrival_time
            , Date arrival_date, Date departure_time, Date departure_date, int remaining_seats) {
        this.plane = plane;
        this.airline = airline;
        this.flight_code = flight_code;
        this.arrival_time = arrival_time;
        this.arrival_date = arrival_date;
        this.departure_time = departure_time;
        this.departure_date = departure_date;
        this.remaining_seats = remaining_seats;

        plane.addFlight(this);
        airline.addFlight(this);
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    public int getFlight_code() {
        return flight_code;
    }

    public void setFlight_code(int flight_code) {
        this.flight_code = flight_code;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public Date getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(Date arrival_date) {
        this.arrival_date = arrival_date;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public int getRemaining_seats() {
        return remaining_seats;
    }

    public void setRemaining_seats(int remaining_seats) {
        this.remaining_seats = remaining_seats;
    }

    public void removeReservation(Reservation reservation) {
        reservationList.remove(reservation);
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
