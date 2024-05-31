import java.util.*;

public class DataBase {

    public List<Passenger> passengers;
    public List<Train> trains;

    public DataBase() {
        passengers = new ArrayList<>();
        trains = new ArrayList<>();
        passengers.add(new Passenger("Virat Kohli", "male", 32, "Upper", ClassType.A1));
        passengers.add(new Passenger("Dhoni", "male", 41, "Lower", ClassType.A2));
        passengers.add(new Passenger("Bumrah", "male", 34, "Side Upper", ClassType.A3));
        trains.add(new Train("Chennai", "Madurai", 8, "Chennai Express", 2, 2, 2, 2));
        trains.add(new Train("Coimbatore", "Tiruchirappalli", 8, "Coimbatore Express", 2, 2, 2, 2));
        trains.add(new Train("Salem", "Erode", 8, "Salem Express", 2, 2, 2, 2));
        trains.add(new Train("Tirunelveli", "Thoothukudi", 8, "Tirunelveli Express", 2, 2, 2, 2));
        trains.add(new Train("Vellore", "Chennai", 8, "Vellore Express", 2, 2, 2, 2));
        trains.add(new Train("Chennai", "Madurai", 8, "Malli Express", 2, 2, 2, 2));
        trains.add(new Train("Coimbatore", "Tiruchirappalli", 8, "Rock fort Express", 2, 2, 2, 2));
        trains.add(new Train("Salem", "Erode", 8, "Erode Express", 2, 2, 2, 2));
        trains.add(new Train("Tirunelveli", "Thoothukudi", 8, "halwa Express", 2, 2, 2, 2));
        trains.add(new Train("Vellore", "Chennai", 8, "Vellore Express", 2, 2, 2, 2));
        trains.add(new Train("Madurai", "Coimbatore", 8, "Madurai Express", 2, 2, 2, 2));
        trains.add(new Train("Tiruchirappalli", "Salem", 8, "Tiruchirappalli Express", 2, 2, 2, 2));
        trains.add(new Train("Erode", "Tirunelveli", 8, "Erode Express", 2, 2, 2, 2));
        trains.add(new Train("Thoothukudi", "Vellore", 8, "Thoothukudi Express", 2, 2, 2, 2));
        trains.add(new Train("Chennai", "Coimbatore", 8, "Chennai-Coimbatore Express", 2, 2, 2, 2));
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Train> getTrains() {
        return trains;
    }

}
