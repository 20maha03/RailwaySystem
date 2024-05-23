import java.util.*;

public class DataBase {
   
    public List<Passenger> passengers;
    public List<Train> trains;

    public DataBase() {
        passengers = new ArrayList<>();
        trains = new ArrayList<>();
        passengers.add(new Passenger("Virat Kohli", "male", 32, "Upper","1A"));
        passengers.add(new Passenger("Dhoni", "male", 41, "Lower","2A"));
        passengers.add(new Passenger("Bumrah", "male", 34, "Side Upper","3A"));
        trains.add(new Train("US", "India", 8, "Pacific Express",2,2,2,2));
        trains.add(new Train("Delhi", "Tamil Nadu", 8, "Tajmahal Express",2,2,2,2));
        trains.add(new Train("UK", "India", 8, "Pacific Express",2,2,2,2));
    }


    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Train> getTrains() {
        return trains;
    }

}
