package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@PersistenceCapable
public class Flight {
    private int flight_code;
    private Airline airline; /* Foreign Key */
    private String departure_airport;
    private String destination_airport;
    private Date arrival_time;
    private Date arrival_date;
    private Date departure_time;
    private Date departure_date;
    private int total_time;
    private int remaining_time;
    private List<Reservation> reservationList = new ArrayList<>();


    public Flight(int flight_code, Airline airline, String departure_airport, String destination_airport, Date arrival_time, Date arrival_date, Date departure_time, Date departure_date, int total_time, int remaining_time) {
        this.flight_code = flight_code;
        this.airline = airline;
        this.departure_airport = departure_airport;
        this.destination_airport = destination_airport;
        this.arrival_time = arrival_time;
        this.arrival_date = arrival_date;
        this.departure_time = departure_time;
        this.departure_date = departure_date;
        this.total_time = total_time;
        this.remaining_time = remaining_time;
    }


    public int getFlight_code() {
        return flight_code;
    }

    public void setFlight_code(int flight_code) {
        this.flight_code = flight_code;
    }


    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getDestination_airport() {
        return destination_airport;
    }

    public void setDestination_airport(String destination_airport) {
        this.destination_airport = destination_airport;
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

    public int getTotal_time() {
        return total_time;
    }

    public void setTotal_time(int total_time) {
        this.total_time = total_time;
    }

    public int getRemaining_time() {
        return remaining_time;
    }

    public void setRemaining_time(int remaining_time) {
        this.remaining_time = remaining_time;
    }

    public void addReservation(Reservation reservation) {
        reservationList.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservationList.remove(reservation);
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }
}
