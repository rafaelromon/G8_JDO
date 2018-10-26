package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.PersistenceCapable;
import java.util.Date;

@PersistenceCapable
public class Payment {
    private Date payment_date;
    private int total_price;
    private Reservation reservation;

    public Payment(Date payment_date, int total_price, Reservation reservation) {
        this.payment_date = payment_date;
        this.total_price = total_price;
        this.reservation = reservation;

        reservation.setPayment(this);
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
