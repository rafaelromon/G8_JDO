package es.deusto.ingenieria.sd.jdo.easybooking;

/*  TODO Finish Main
 *  TODO Config Data
 *
 * */

public class Main {
    public static void main(String[] args) {
        User rafa = new User(1, "Rafael", "rafaelromon@opendeusto.es"
                , "Google", "Paypal", "Bilbao");

        Person luis = new Person(2, "Luis");
        Person leyre = new Person(3, "Leyre");
        Person pablo = new Person(4, "Pablo");
        
        Airline iberia = new Airline(5, "iberia");
    	Airline airCanada = new Airline(6,"airCanada");
    	
    	Airport madrid = new Airport(7, "barajas");
    	Airport bilbao = new Airport(8, "laPaloma");
    	
    	Reservation R1 = new Reservation(9, "fecha", rafa, F1);
    	
    	Plane P1 = new Plane(iberia, 11, madrid, bilbao, 100);
    	
    	Flight F1 = new Flight(P1,12,iberia, madrid, bilbao, time,date ,time,date,3,80);
    	
    	Reservation R1 = new Reservation(13,date,rafa,F1);
    }
}
