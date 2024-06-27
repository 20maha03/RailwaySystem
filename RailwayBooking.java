import java.util.*;

public class RailwayBooking {
    
    private DataBase db = new DataBase();
    public List<Ticket> tempTickets = new ArrayList<>();
    public List<Ticket> waitingListTickets = new ArrayList<>();
    public HashMap<String, Integer> bookedTickets = new HashMap<>();
    public List<User> tempUsers = new ArrayList<>();
    int seatNumber = 1;
    int count = 1;
    private User.Role role;

    public boolean bookTheTicket(String username, String name, String gender, int age, BerthPreference berthPreference, ClassType classType, String from, String to, String trainName) {
        List<Train> availableTrains = checkTrains(from, to);
        boolean isFound = false;
        for (Train t : availableTrains) {
            if (trainName.equals(t.getTrainName()) && isSeatAvailable(t, classType, berthPreference)) {
            
                bookSeat(t, classType, berthPreference);
                Ticket newTicket = new Ticket(name, gender, age, berthPreference, classType);
                db.tickets.add(newTicket);
                String ticketKey = generateTicketKey(to, classType, seatNumber++, berthPreference);
                System.out.println("Ticket id: " + ticketKey);
                bookedTickets.put(ticketKey, count++);

                for (User user : db.getUsers()) {
                    if (user.getUserName().equals(username)) {
                        user.addTicket(ticketKey);
                    }
                }
                isFound = true;
            }
        }
        if(isFound) {
            tempTickets.add(new Ticket(name, gender, age, berthPreference, classType));
        }
        else {
            waitingListTickets.add(new Ticket(name, gender, age, berthPreference, classType));
        }
        return isFound;
    }

    public List<String> getUserTickets(String username) {
        for (User user : db.getUsers()) {
            if (user.getUserName().equals(username)) {
                return user.getTickets();
            }
        }
        return new ArrayList<>();
    }

    public boolean isSeatAvailable(Train train, ClassType classType, BerthPreference berthPreference) {
        return train.getSeatCount(classType, berthPreference) > 0;
    }

    public void bookSeat(Train train, ClassType classType, BerthPreference berthPreference) {
        train.setSeatCount(classType, berthPreference, train.getSeatCount(classType, berthPreference) - 1);
    }

    public List<Train> checkTrains(String from, String to) {
        List<Train> tempTrain = new ArrayList<>();
        for (Route route : db.getRoutes()) {
            if (route.getAllStation().containsKey(from) && route.getAllStation().containsKey(to)
                && route.getAllStation().get(from) < route.getAllStation().get(to)) {
                for (Train train : db.getTrains()) {
                    if (train.getTrainId() == route.getRouteId()) {
                        tempTrain.add(train);
                    }
                }
            }
        }
        return tempTrain;
    }

    public boolean cancelTheTicket(String name) {
        for (Ticket e : db.getTickets()) {
            if (name.equals(e.getNameOfThePassenger())) {
                db.tickets.remove(e);
                return true;
            }
        }
        return false;
    }

    public boolean moveTicketStatus() {
        if (!tempTickets.isEmpty()) {
            Ticket ticket = tempTickets.remove(0);
            db.tickets.add(ticket);
            return true;
        }
        return false;
    }

    public List<Ticket> getAllTickets() {
        if (!db.getTickets().isEmpty()) {
            return db.getTickets();
        }
        return null;
    }

    public boolean toLogin(String username, String password) {
        for (User u : db.getUsers()) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isAdmin(String username, String password) {
        for (User a : db.getUsers()) {
            role = a.getRole();
            if (a.getUserName().equals(username) && a.getPassword().equals(password) && role.equals("Admin")) {
                return true;
            }
        }
        return false;
    }

    public void addNewTrain( String nameOfTheTrain,String startStation, String endStation, HashMap<String, Integer> interMediateStation,int availableSeats, String dateOfTrain) {
        Train newTrain = new Train(nameOfTheTrain,db.getTrains().size() + 1, startStation, endStation, availableSeats, dateOfTrain);
        db.trains.add(newTrain);
        Route newRoute = new Route(db.getRoutes().size() + 1, interMediateStation,startStation,endStation);
        db.routes.add(newRoute);
    }

    public void deleteTrain(String nameOfTheTrain) {
        for (Train t : db.getTrains()) {
            if (t.getTrainName().equals(nameOfTheTrain)) {
                db.trains.remove(t);
                for (Route r : db.getRoutes()) {
                    if (r.getRouteId() == t.getTrainId()) {
                        db.routes.remove(r);
                        break;
                    }
                }
                break;
            }
        }
    }

    public String generateTicketKey(String destination, ClassType classType, int seatNumber, BerthPreference berthPreference) {
        return destination + "/" + classType + "/" + seatNumber + "/" + berthPreference;
    }

    public void addNewUser(String username, String password, User.Role role) {
        User newUser = new User(username, password, role);
        db.users.add(newUser);
    }

    public void deleteUser(String username, String password) {
        for (User u : db.getUsers()) {
            if (u.getUserName().equals(username) && u.getPassword().equals(password)) {
                db.users.remove(u);
                break;
            }
        }
    }
}
