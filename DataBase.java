import java.util.*;

public class DataBase {
   
    public List<Passenger> passengers = new ArrayList<Passenger>();

    {
        passengers.add(new Passenger("Virat kohli", "male", 32 ,"Upper"));
        passengers.add(new Passenger("Dhoni", "male", 41, "Lower"));
        passengers.add(new Passenger("pumrah","male", 34, "sideUpper")); 
    }
    public List<Passenger> getAllPassenger() {
        return passengers;
    }
    
}