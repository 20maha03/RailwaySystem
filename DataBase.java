import java.util.*;

public class DataBase {
    public List<Passenger> passengers;
    public List<Train> trains;
    public List<User> users;
    public static HashMap<String, Integer> t1 = new HashMap<>();
    public static HashMap<String, Integer> t2 = new HashMap<>();
    public static HashMap<String, Integer> t3 = new HashMap<>();
    public static HashMap<String, Integer> t4 = new HashMap<>();
    public static HashMap<String, Integer> t5 = new HashMap<>();
    public static HashMap<String, Integer> t6 = new HashMap<>();

    static {
        t1.put("Trichy", 1);
        t1.put("Chennai", 2);
        t1.put("Madurai", 3);
        t1.put("Vellore", 4);

        t2.put("Vellore", 1);
        t2.put("Trichy", 2);
        t2.put("Chennai", 3);
        t2.put("Madurai", 4);

        t3.put("Salem", 1);
        t3.put("Trichy", 2);
        t3.put("Erode", 3);
        t3.put("Chennai", 4);

        t4.put("Tirunelveli", 1);
        t4.put("Trichy", 2);
        t4.put("Thoothukudi", 3);
        t4.put("Madurai", 4);

        t5.put("Vellore", 1);
        t5.put("Trichy", 2);
        t5.put("Chennai", 3);
        t5.put("Kumbakonam", 4);
        t5.put("Salem", 5);

        t6.put("Chennai", 1);
        t6.put("Trichy", 2);
        t6.put("Madurai", 3);
        t6.put("Kumbakonam", 4);
        t6.put("Tirunelveli", 5);
    }

    public DataBase() {
        passengers = new ArrayList<>();
        trains = new ArrayList<>();
        users = new ArrayList<>(); // Initialize the users list

        passengers.add(new Passenger("Virat Kohli", "male", 32, BerthPreference.UB, ClassType.A1));
        passengers.add(new Passenger("Dhoni", "male", 41, BerthPreference.LB, ClassType.A2));
        passengers.add(new Passenger("Bumrah", "male", 34, BerthPreference.SU, ClassType.A3));

        trains.add(new Train(t1, 8, "Chennai Express"));
        trains.add(new Train(t2, 8, "Coimbatore Express"));
        trains.add(new Train(t3, 8, "Salem Express"));
        trains.add(new Train(t4, 8, "Tirunelveli Express"));
        trains.add(new Train(t5, 8, "Vellore Express"));
        trains.add(new Train(t6, 8, "Malli Express"));

        users.add(new User("Maha", "Maha@123"));
        users.add(new User("Bhu", "Bhu@123"));
        users.add(new User("Go", "Go@123"));
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public List<User> getUsers() {
        return users;
    }
}
