import java.util.*;

public class DataBase {
    public List<Passenger> passengers;
    public List<Train> trains;
    public List<User> users;
    public List<Route> routes;
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
        users = new ArrayList<>();
        routes = new ArrayList<>();

        passengers.add(new Passenger("Virat Kohli", "male", 32, BerthPreference.UB, ClassType.A1));
        passengers.add(new Passenger("Dhoni", "male", 41, BerthPreference.LB, ClassType.A2));
        passengers.add(new Passenger("Bumrah", "male", 34, BerthPreference.SU, ClassType.A3));

        trains.add(new Train("Chennai Express", 1, 8, "03/07/2024"));
        trains.add(new Train("Coimbatore Express", 2, 8, "05/07/2024"));
        trains.add(new Train("Salem Express", 3, 8, "06/07/2024"));
        trains.add(new Train("Tirunelveli Express", 4, 8, "01/02/2024"));
        trains.add(new Train("Vellore Express", 5, 8, "07/07/2024"));
        trains.add(new Train("Malli Express", 6, 8, "10/07/2024"));

        users.add(new User("Maha", "Maha@123", User.RoleOfTheUser.ADMIN));
        users.add(new User("Bhu", "Bhu@123", User.RoleOfTheUser.USER));
        users.add(new User("Go", "Go@123", User.RoleOfTheUser.ADMIN));

        routes.add(new Route(1,t1));
        routes.add(new Route(2,t2));
        routes.add(new Route(3,t3));
        routes.add(new Route(4,t4));
        routes.add(new Route(5,t5));
        routes.add(new Route(6,t6));
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
    public List<Route> getRoutes() {
        return routes;
    }
}
