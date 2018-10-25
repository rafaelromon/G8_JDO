package es.deusto.ingenieria.sd.jdo.easybooking;

/* TODO Create orm File
 * TODO Finish Main
 */

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import java.text.SimpleDateFormat;

public class Main {

    private static SimpleDateFormat format_date = new SimpleDateFormat("dd-MM-yyyy");
    private static SimpleDateFormat format_time = new SimpleDateFormat("hh:mm");

    public static void main(String[] args) {
        System.out.println("Starting Easybooking Example...");
        System.out.println("===============================================");
        try {
            System.out.println("Creating Objects");

            User rafa = new User(1, "Rafael", "rafaelromon@opendeusto.es",
                    "Google", "Paypal", "Bilbao");

            Person luis = new Person(2, "Luis");
            Person leyre = new Person(3, "Leyre");
            Person pablo = new Person(4, "Pablo");

            Airline iberia = new Airline(5, "iberia");

            Airport madrid = new Airport(7, "barajas");
            Airport bilbao = new Airport(8, "laPaloma");

            Plane P1 = new Plane(iberia, 11, madrid, bilbao, 100);

            Flight F1 = new Flight(P1, 12, format_time.parse("22:55"),
                    format_date.parse("23-01-2019"), format_time.parse("23:55"),
                    format_date.parse("23-01-2019"), 3);

            P1.addFlight(F1);
            /* Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml */
            PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            /* Persistence Manager */
            PersistenceManager pm = null;
            /* Transaction to group DB operations */
            Transaction tx = null;

            try {
                System.out.println("Storign Objects in DB");
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

                pm.makePersistent(madrid);
                pm.makePersistent(bilbao);

                pm.makePersistent(P1);
                pm.makePersistent(F1);


                /* End the transaction */
                tx.commit();

                System.out.println("Objects and Relationships Stored");
                System.out.println("Adding Reservation");
                System.out.println("User: " + rafa.getName() + " reservation list: ");
                for (Reservation r : rafa.getUser_reservationList()) {
                    System.out.println("\t " + r.getReservation_code());
                }
                Reservation R1 = new Reservation(13, format_date.parse("20-01-2019"), rafa, F1);
                rafa.addReservation(R1);
                System.out.println("User: " + rafa.getName() + " reservation list: ");
                for (Reservation r : rafa.getUser_reservationList()) {
                    System.out.println("\t " + r.getReservation_code());
                }
                /*System.out.println("    - " + account1.getBankName() + "($ " + account1.getBalance() + ")");

                System.out.println("Open Date: " + account1.getOpenDate());

                System.out.println("    + " + account2.getBankName() + "($ " + account2.getBalance() + ")");
                account1.debit(100);
                account2.credit(100);
                System.out.println("  * Money transferred!");
                System.out.println("    - " + account1.getBankName() + "($ " + account1.getBalance() + ")");
                System.out.println("    + " + account2.getBankName() + "($ " + account2.getBalance() + ")");*/
            } catch (Exception ex) {
                System.err.println(" $ Error storing objects in the DB: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                if (tx != null && tx.isActive()) {
                    tx.rollback();
                }

                if (pm != null && !pm.isClosed()) {
                    pm.close();
                    // ATTENTION -  Datanucleus detects that the objects in memory were changed and they are flushed to DB
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
