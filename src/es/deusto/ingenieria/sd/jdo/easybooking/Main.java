package es.deusto.ingenieria.sd.jdo.easybooking;

/* TODO Create orm File
 */

import javax.jdo.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    private static SimpleDateFormat format_date = new SimpleDateFormat("dd-MM-yyyy");
    private static SimpleDateFormat format_time = new SimpleDateFormat("hh:mm");

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("Starting Easybooking Example...");
        System.out.println("===============================================");
        try {

            System.out.println("- Creating and Storing Objects ");
            User rafa = new User(1, "Rafael", "rafaelromon@opendeusto.es",
                    "Google", "Paypal", "Bilbao");
            User luis = new User(2, "Luis", "luis.urre@opendeusto.es\n",
                    "Facebook", "Visa", "Bilbao");
            Person leyre = new Person(3, "Leyre");
            Person pablo = new Person(4, "Pablo");

            Airline iberia = new Airline(1, "Iberia");
            Airline air_france = new Airline(2, "Air France");

            Airport madrid = new Airport(1, "Barajas");
            Airport bilbao = new Airport(2, "La Paloma");
            Airport londres = new Airport(3, "Heathrow");
            Airport berlin = new Airport(4, "Tegel");

            Plane plane1 = new Plane(1, madrid, bilbao, 100);
            Plane plane2 = new Plane(2, bilbao, berlin, 75);
            Plane plane3 = new Plane(3, londres, berlin, 150);

            Flight flight1 = new Flight(iberia, plane1, 1, format_time.parse("22:55"),
                    format_date.parse("23-01-2019"), format_time.parse("23:55"),
                    format_date.parse("23-01-2019"), 3);

            Flight flight2 = new Flight(air_france, plane2, 2, format_time.parse("10:30"),
                    format_date.parse("24-01-2019"), format_time.parse("13:00"),
                    format_date.parse("24-01-2019"), 3);

            Flight flight3 = new Flight(air_france, plane3, 3, format_time.parse("17:00"),
                    format_date.parse("24-01-2019"), format_time.parse("19:50"),
                    format_date.parse("24-01-2019"), 3);

            /* Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml */
            PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            /* Persistence Manager */
            PersistenceManager pm = null;
            /* Transaction to group DB operations */
            Transaction tx = null;

            try {
                System.out.println("- Storing Objects in DB");
                /* Get the Persistence Manager */
                pm = pmf.getPersistenceManager();
                /* Obtain the current transaction */
                tx = pm.currentTransaction();
                /* Start the transaction */
                tx.begin();

                pm.makePersistent(rafa);
                pm.makePersistent(luis);
                pm.makePersistent(leyre);
                pm.makePersistent(pablo);

                pm.makePersistent(iberia);
                pm.makePersistent(air_france);

                pm.makePersistent(madrid);
                pm.makePersistent(bilbao);
                pm.makePersistent(berlin);
                pm.makePersistent(londres);

                pm.makePersistent(plane1);
                pm.makePersistent(plane2);
                pm.makePersistent(plane3);
                pm.makePersistent(flight1);
                pm.makePersistent(flight2);
                pm.makePersistent(flight3);


                /* End the transaction */
                tx.commit();

                System.out.println("- Objects and Relationships Stored");
                System.out.println("===============================================");
                System.out.println("- Testing Operations");
                System.out.println("- Before Adding Reservation");
                System.out.println("    -> User: " + rafa.getName() + " reservations ("
                        + rafa.getReservationList().size() + "): ");
                for (Reservation r : rafa.getReservationList()) {
                    System.out.println("            " + r.getReservation_code() + " - "
                            + r.getFlight().getAirline().getAirline_name() + " " + r.getFlight().getFlight_code());
                }


                Reservation reservation1 = new Reservation(1, rafa, flight1);
                Reservation reservation2 = new Reservation(2, rafa, flight2);
                Reservation reservation3 = new Reservation(3, luis, flight3);

                pm.makePersistent(reservation1);
                pm.makePersistent(reservation2);
                pm.makePersistent(reservation3);

                reservation1.addPerson(luis);
                reservation1.addPerson(pablo);
                reservation1.addPerson(leyre);

                reservation2.addPerson(luis);
                reservation2.addPerson(pablo);

                reservation3.addPerson(pablo);

                System.out.println("- After Adding Reservation");
                System.out.println("    -> User: " + rafa.getName() + " reservations ("
                        + rafa.getReservationList().size() + "): ");
                for (Reservation r : rafa.getReservationList()) {
                    System.out.println("            " + r.getReservation_code() + " - "
                            + r.getFlight().getAirline().getAirline_name() + " " + r.getFlight().getFlight_code());
                }
                System.out.println("- Before Adding Payment");
                System.out.println("    -> Reservation " + reservation1.getReservation_code() + " is payed: " + reservation1.isPayed());

                Payment payment = new Payment(format_date.parse("21-01-2019"), 150, reservation1);
                reservation1.setPayment(payment);
                pm.makePersistent(payment);

                System.out.println("- After Adding Payment");
                System.out.println("    -> Reservation " + reservation1.getReservation_code() + " is payed: " + reservation1.isPayed());
            } catch (Exception ex) {
                System.err.println(" $ Error Storing Objects in DB: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }

                if (pm != null && !pm.isClosed()) {
                    pm.close();
                    /* ATTENTION -
                    Datanucleus detects that the objects in memory were changed and they are flushed to DB */
                }
            }
            try {
                System.out.println("===============================================");
                System.out.println("- Retrieving all Persons using an 'Extent'...");
                /* Get the Persistence Manager */
                pm = pmf.getPersistenceManager();
                /* Obtain the current transaction */
                tx = pm.currentTransaction();
                /* Start the transaction */
                tx.begin();

                Extent<Flight> extent = pm.getExtent(Flight.class, true);

                for (Flight flight : extent) {
                    System.out.println("    -> " + flight);
                }
                /*End the transaction */
                tx.commit();
            } catch (Exception ex) {
                System.err.println(" $ Error retrieving flights using an 'Extent': " + ex.getMessage());
            } finally {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }

                if (pm != null && !pm.isClosed()) {
                    pm.close();
                }
            }

            try {
                System.out.println("===============================================");
                System.out.println("- Retrieving planes with >= 100 seats using a 'Query'...");
                /* Get the Persistence Manager */
                pm = pmf.getPersistenceManager();
                /* Obtain the current transaction */
                tx = pm.currentTransaction();
                /* Start the transaction */
                tx.begin();

                @SuppressWarnings("unchecked")
                Query<Plane> query = pm.newQuery(Plane.class);
                query.setFilter("total_seats >= 100");

                @SuppressWarnings("unchecked")
                List<Plane> planes = (List<Plane>) query.execute();

                /* End the transaction */
                tx.commit();

                for (Plane plane : planes) {
                    System.out.println("    -> plane " + plane.getPlane_code() + " seats: " + plane.getTotal_seats());
                }
            } catch (Exception ex) {
                System.err.println(" $ Error retrieving planes using a 'Query': " + ex.getMessage());
            }
            try {
                System.out.println("===============================================");
                System.out.println("- Deleting 'Person->Reservation' relation...");
                /* Get the Persistence Manager */
                pm = pmf.getPersistenceManager();
                /* Obtain the current transaction */
                tx = pm.currentTransaction();
                /* Start the transaction */
                tx.begin();

                Query<Person> query = pm.newQuery(Person.class);
                @SuppressWarnings("unchecked")
                List<Person> people = (List<Person>) query.execute();

                for (Person person : people) {
                    System.out.println("  -> Retrieved Person: " + person.getName());
                    System.out.println("     + Removing Person from the Reservations ... ");
                    for (Reservation reservation : person.getSeatList()) {
                        reservation.removePerson(person);
                    }
                }

                //End the transaction
                tx.commit();
            } catch (Exception ex) {
                System.err.println(" $ Error deleting 'User->Address' relation: " + ex.getMessage());
            } finally {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }

                if (pm != null && !pm.isClosed()) {
                    pm.close();
                }
            }

            System.out.println("===============================================");
            System.out.println("End of Easybooking Example...");
            System.out.println("===============================================");

        } catch (
                Exception e) {
            System.out.println(e.toString());
        }
    }
}
