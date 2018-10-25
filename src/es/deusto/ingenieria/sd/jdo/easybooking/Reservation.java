package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@PersistenceCapable
public class Reservation {
    private int reservation_code;
    private User user;
    private Flight flight;
    private List<Person> personList = new ArrayList<>();

    public Reservation(int reservation_code, Date reservation_date, User user, Flight flight) {
        this.reservation_code = reservation_code;
        this.user = user;
        this.flight = flight;
    }

    public int getReservation_code() {
        return reservation_code;
    }

    public void setReservation_code(int reservation_code) {
        this.reservation_code = reservation_code;
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

    public void addPerson(Person person) {
        personList.add(person);
    }

    public void removePerson(Person person) {
        personList.remove(person);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
