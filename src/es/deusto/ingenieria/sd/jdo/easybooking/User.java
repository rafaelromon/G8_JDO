package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class User extends Person {
    private String email;
    private String authorization_system;
    private String payment_method;
    private String default_airport;
    private List<Reservation> user_reservationList = new ArrayList<>();

    public User(int id, String name, String email, String authorization_system, String payment_method, String default_airport) {
        super(id, name);
        this.email = email;
        this.authorization_system = authorization_system;
        this.payment_method = payment_method;
        this.default_airport = default_airport;
    }

    /* Getter and Setter */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthorization_system() {
        return authorization_system;
    }

    public void setAuthorization_system(String authorization_system) {
        this.authorization_system = authorization_system;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getDefault_airport() {
        return default_airport;
    }

    public void setDefault_airport(String default_airport) {
        this.default_airport = default_airport;
    }

    public void addReservation(Reservation reservation) {
        user_reservationList.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        user_reservationList.remove(reservation);
    }

    public List<Reservation> getUser_reservationList() {
        return user_reservationList;
    }
}
