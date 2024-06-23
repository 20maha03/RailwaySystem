import java.util.*;

public class DataBase {

    public List<Passenger> passengers;
    public List<Train> trains;

    public DataBase() {
        passengers = new ArrayList<>();
        trains = new ArrayList<>();
        passengers.add(new Passenger("Virat Kohli", "male", 32, BerthPreference.UB, ClassType.A1));
        passengers.add(new Passenger("Dhoni", "male", 41, BerthPreference.LB, ClassType.A2));
        passengers.add(new Passenger("Bumrah", "male", 34, BerthPreference.SU, ClassType.A3));
        trains.add(new Train("Chennai", "Madurai", 8, "Chennai Express"));
        trains.add(new Train("Coimbatore", "Tiruchirappalli", 8, "Coimbatore Express"));
        trains.add(new Train("Salem", "Erode", 8, "Salem Express"));
        trains.add(new Train("Tirunelveli", "Thoothukudi", 8, "Tirunelveli Express"));
        trains.add(new Train("Vellore", "Chennai", 8, "Vellore Express"));
        trains.add(new Train("Chennai", "Madurai", 8, "Malli Express"));
        trains.add(new Train("Coimbatore", "Tiruchirappalli", 8, "Rock fort Express"));
        trains.add(new Train("Salem", "Erode", 8, "Erode Express"));
        trains.add(new Train("Tirunelveli", "Thoothukudi", 8, "Halwa Express"));
        trains.add(new Train("Vellore", "Chennai", 8, "Vellore Express"));
        trains.add(new Train("Madurai", "Coimbatore", 8, "Madurai Express"));
        trains.add(new Train("Tiruchirappalli", "Salem", 8, "Tiruchirappalli Express"));
        trains.add(new Train("Erode", "Tirunelveli", 8, "Erode Express"));
        trains.add(new Train("Thoothukudi", "Vellore", 8, "Thoothukudi Express"));
        trains.add(new Train("Chennai", "Coimbatore", 8, "Chennai-Coimbatore Express"));
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Train> getTrains() {
        return trains;
    }
}
