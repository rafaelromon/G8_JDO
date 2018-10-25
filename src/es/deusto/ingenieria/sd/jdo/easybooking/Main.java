package es.deusto.ingenieria.sd.jdo.easybooking;

/*  TODO Finish Main
 *  TODO Config Data
 *
 * */

import java.text.SimpleDateFormat;

public class Main {

    private static SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat format_time = new SimpleDateFormat("hh:mm");

    public static void main(String[] args) {
        try {
            User rafa = new User(1, "Rafael", "rafaelromon@opendeusto.es"
                    , "Google", "Paypal", "Bilbao");

            Person luis = new Person(2, "Luis");
            Person leyre = new Person(3, "Leyre");
            Person pablo = new Person(4, "Pablo");

            Airline iberia = new Airline(5, "iberia");

            Airport madrid = new Airport(7, "barajas");
            Airport bilbao = new Airport(8, "laPaloma");

            Plane P1 = new Plane(iberia, 11, madrid, bilbao, 100);

            Flight F1 = new Flight(P1, 12, iberia, madrid, bilbao, format_time.parse("22:55"),
                    format_date.parse("23-01-19"), format_time.parse("23:55"),
                    format_date.parse("23-01-19"), 3, 80);

            Reservation R1 = new Reservation(9, format_date.parse("20-01-19"), rafa, F1);
            R1.addPerson(luis);
            R1.addPerson(leyre);
            R1.addPerson(pablo);

        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        // Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        // Persistence Manager
        PersistenceManager pm = null;
        //Transaction to group DB operations
        Transaction tx = null;

        try {
            System.out.println("- Store objects in the DB");
            //Get the Persistence Manager
            pm = pmf.getPersistenceManager();
            //Obtain the current transaction
            tx = pm.currentTransaction();
            //Start the transaction
            tx.begin();

            pm.makePersistent(user1);
            pm.makePersistent(user2);

            //End the transaction
            tx.commit();
            System.out.println("  * Objects and their relationships have been stored!");
            System.out.println("- Transferring $100");
            System.out.println("    - " + account1.getBankName() + "($ " + account1.getBalance() + ")");

            System.out.println("Open Date: " + account1.getOpenDate());

            System.out.println("    + " + account2.getBankName() + "($ " + account2.getBalance() + ")");
            account1.debit(100);
            account2.credit(100);
            System.out.println("  * Money transferred!");
            System.out.println("    - " + account1.getBankName() + "($ " + account1.getBalance() + ")");
            System.out.println("    + " + account2.getBankName() + "($ " + account2.getBalance() + ")");
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
}
