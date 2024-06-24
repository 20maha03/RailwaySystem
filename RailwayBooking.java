import java.util.*;

public class RailwayBooking {
    private DataBase db = new DataBase();
    public List<Passenger> tempPassengers = new ArrayList<>();
    public HashMap<String, Integer> bookedTickets = new HashMap<>();
    public List<User> tempUsers = new ArrayList<>();
    int seatNumber = 1;
    int count = 1;

    public boolean bookTheTicket(String username, String name, String gender, int age, BerthPreference berthPreference, ClassType classType, String from, String to, String trainName) {
        List<Train> availableTrains = checkTrains(from, to);
        for (Train t : availableTrains) {
            if (trainName.equals(t.getTrainName())) {
                if (isSeatAvailable(t, classType, berthPreference)) {
                    bookSeat(t, classType, berthPreference);
                    Passenger newPassenger = new Passenger(name, gender, age, berthPreference, classType);
                    db.passengers.add(newPassenger);
                    String ticketKey = generateTicketKey(to, classType, seatNumber++, berthPreference);
                    System.out.println("Ticket id: " + ticketKey);
                    bookedTickets.put(ticketKey, count++);

                    for (User user : db.getUsers()) {
                        if (user.getUserName().equals(username)) {
                            user.addTicket(ticketKey);
                        }
                    }

                    return true;
                } 
            }
        }
        tempPassengers.add(new Passenger(name, gender, age, berthPreference, classType));
        return false;
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
        for (Train t : db.getTrains()) {
            if (t.getInterMediateStation().containsKey(from) && t.getInterMediateStation().containsKey(to)
                && t.getInterMediateStation().get(from) < t.getInterMediateStation().get(to)) {
                tempTrain.add(t);
            }
        }
        return tempTrain;
    }

    public boolean cancelTheTicket(String name) {
        for (Passenger e : db.getPassengers()) {
            if (name.equals(e.getNameOfThePassenger())) {
                db.passengers.remove(e);
                return true;
            }
        }
        return false;
    }

    public boolean moveTicketStatus() {
        if (!tempPassengers.isEmpty()) {
            Passenger passenger = tempPassengers.remove(0);
            db.passengers.add(passenger);
            return true;
        }
        return false;
    }

    public List<Passenger> getAllPassenger() {
        if (!db.getPassengers().isEmpty()) {
            return db.getPassengers();
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
        for (Admin a : db.getAdmins()) {
            if (a.getAdminName().equals(username) && a.getAdminPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void toAddNewTrain(HashMap<String, Integer> interMediateStation, String nameOfTheTrain, int availableSeats, String dateOfTrain) {
        Train newTrain = new Train(interMediateStation,availableSeats,nameOfTheTrain,dateOfTrain);
        db.trains.add(newTrain);
    }

    public void toDeleteTrain(String nameOfTheTrain) {
        for (Train t : db.getTrains()) {
            if (t.getTrainName().equals(nameOfTheTrain)) {
                db.trains.remove(t);
            }
        }
    }

   
    public String generateTicketKey(String destination, ClassType classType, int seatNumber, BerthPreference berthPreference) {
        return destination + "/" + classType + "/" + seatNumber + "/" + berthPreference;
    }


}
