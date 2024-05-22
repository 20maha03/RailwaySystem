import java.util.*;

public class Process {

    DataBase db = new DataBase();

    public List<Passenger> tempPassengers = new ArrayList<Passenger>();

    public String bookTheTicket(String name,String gender,  int age, String berthPreference) {
      if (db.passengers.size() < 10) {
          db.passengers.add(new Passenger(name,gender,age,berthPreference));
          return "ticket booked succesfully " + name;
      }
      else {
         tempPassengers.add(new Passenger(name,gender,age,berthPreference));
         return "sorry you are waiting list";
      }
      
    }
    public String cancelTheTicket(String name) {
        for (Passenger e : db.getAllPassenger()) {
            if (name.equals(e.getNameOfThePassenger())) {
                db.passengers.remove(e);
                return "your ticket cancelled" + name;
                
            }
        }
        return "your ticket is not avilable in our data base";
    }
     public String movedTicketStatus() {
        if (tempPassengers.size() != 0) {
            Passenger passenger = tempPassengers.remove(0); 
            db.passengers.add(passenger);
            return passenger + " ticket is confirmed";
        }
        return "No passengers in the waiting list";
    }
}