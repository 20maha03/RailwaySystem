import java.io.*;
import java.util.*;

public class DataBase {
    public List<Ticket> tickets;
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
        tickets = new ArrayList<>();
        trains = new ArrayList<>();
        users = new ArrayList<>();
        routes = new ArrayList<>();

        tickets.add(new Ticket("Virat Kohli", "male", 32, BerthPreference.UB, ClassType.A1));
        tickets.add(new Ticket("Dhoni", "male", 41, BerthPreference.LB, ClassType.A2));
        tickets.add(new Ticket("Bumrah", "male", 34, BerthPreference.SU, ClassType.A3));

        readTrainsFromCSV("data.csv");

        users.add(new User("Maha", "Maha@123", User.Role.ADMIN));
        users.add(new User("Bhu", "Bhu@123", User.Role.USER));
        users.add(new User("Go", "Go@123", User.Role.ADMIN));

        routes.add(new Route(2, t2, "Gujarat", "Hyderabad"));
        routes.add(new Route(3, t3, "Delhi", "Kanniyakumari"));
        routes.add(new Route(4, t4, "Hyderabad", "Gujarat"));
        routes.add(new Route(5, t5, "Bangalore", "Punjab"));
        routes.add(new Route(6, t6, "Punjab", "Bangalore"));
        routes.add(new Route(1, t1, "Kanniyakumari", "Delhi"));
    }

    public void readTrainsFromCSV(String filePath) {
        String line = "";
        String d = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        
            while ((line = br.readLine()) != null) {
                String[] data = line.split(d);

                if (data.length != 6) {
                    throw new IOException("Invalid data length: expected 6 columns, found " + data.length);
                }


                int trainId = Integer.parseInt(data[1].trim());
                String trainName = data[0].trim();
                String startStation = data[2].trim();
                String endStation = data[3].trim();
                int availableSeats = Integer.parseInt(data[4].trim());
                String dateOfTrain = data[5].trim();

                Train train = new Train(trainName, trainId, startStation, endStation, availableSeats, dateOfTrain);
                trains.add(train);
    
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        catch (NumberFormatException  e) {
            System.err.println("Error parsing integer from CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Ticket> getTickets() {
        return tickets;
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
