package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@PersistenceCapable
public class Flight {
    private Plane plane;
    private int flight_code;
    private Date arrival_time;
    private Date arrival_date;
    private Date departure_time;
    private Date departure_date;
    private int remaining_seats;
    private List<Reservation> flight_reservationList = new ArrayList<>();


    public Flight(Plane plane, int flight_code, Date arrival_time, Date arrival_date, Date departure_time, Date departure_date, int remaining_seats) {
        this.plane = plane;
        this.flight_code = flight_code;
        this.arrival_time = arrival_time;
        this.arrival_date = arrival_date;
        this.departure_time = departure_time;
        this.departure_date = departure_date;
        this.remaining_seats = remaining_seats;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public void addReservation(Reservation reservation) {
        flight_reservationList.add(reservation);
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
        flight_reservationList.remove(reservation);
    }

    public List<Reservation> getFlight_reservationList() {
        return flight_reservationList;
    }

    public void setFlight_reservationList(List<Reservation> flight_reservationList) {
        this.flight_reservationList = flight_reservationList;
    }
}
