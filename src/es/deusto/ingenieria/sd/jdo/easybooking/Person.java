package es.deusto.ingenieria.sd.jdo.easybooking;

import javax.jdo.annotations.PersistenceCapable;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable
public class Person {
    private int id;
    private String name;
    private List<Reservation> seatList = new ArrayList<>();

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSeat(Reservation seat) {
        seatList.add(seat);
    }

    public void removeSeat(Reservation seat) {
        seatList.remove(seat);
    }

    public List<Reservation> getSeatList() {
        return seatList;
    }
}
