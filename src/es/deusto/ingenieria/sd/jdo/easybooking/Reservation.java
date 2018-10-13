package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.PersistenceCapable;
import java.util.Date;

@PersistenceCapable
public class Reservation {
    private int reservation_code;
    private Date reservation_date;
    private User user;
    private Flight flight;

    public Reservation(int reservation_code, Date reservation_date, User user, Flight flight) {
        this.reservation_code = reservation_code;
        this.reservation_date = reservation_date;
        this.user = user;
        this.flight = flight;
    }

    public int getReservation_code() {
        return reservation_code;
    }

    public void setReservation_code(int reservation_code) {
        this.reservation_code = reservation_code;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
