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
        trains.add(new Train("Chennai", "Trichy","Madurai","Vellore", 8, "Chennai Express"));
        trains.add(new Train("Coimbatore","Madurai", "Tiruchirappalli","Chennai", 8, "Coimbatore Express"));
        trains.add(new Train("Salem", "Trichy","Erode","Chennai", 8, "Salem Express"));
        trains.add(new Train("Tirunelveli", "Trichy","Thoothukudi","Madurai", 8, "Tirunelveli Express"));
        trains.add(new Train("Vellore", "Trichy","Chennai","Salem", 8, "Vellore Express"));
        trains.add(new Train("Chennai", "Trichy","Madurai","Tirunelveli", 8, "Malli Express"));
        trains.add(new Train("Coimbatore", "Madurai","Tiruchirappalli","Salem", 8, "Rock fort Express"));
        trains.add(new Train("Salem", "Trichy","Erode","Madurai", 8, "Erode Express"));
        trains.add(new Train("Tirunelveli","Madurai", "Thoothukudi","Chennai", 8, "Halwa Express"));
        trains.add(new Train("Vellore","Arakonam", "Chennai", "Trichy",8, "Vellore Express"));
        trains.add(new Train("Madurai", "Trichy","Coimbatore","Erode", 8, "Madurai Express"));
        trains.add(new Train("Tiruchirappalli", "Madurai","Salem","Vellore", 8, "Tiruchirappalli Express"));
        trains.add(new Train("Erode", "Madurai","Tirunelveli", "Trichy",8, "Erode Express"));
        trains.add(new Train("Thoothukudi", "Madurai","Vellore","Tirunelveli", 8, "Thoothukudi Express"));
        trains.add(new Train("Chennai","Madurai", "Coimbatore","Erode", 8, "Chennai-Coimbatore Express"));
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Train> getTrains() {
        return trains;
    }
}
