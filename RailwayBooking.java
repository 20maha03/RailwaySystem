import java.util.*;

public class RailwayBooking {

    private DataBase db = new DataBase();
    public List<Passenger> tempPassengers = new ArrayList<>();
    public HashMap<String, Integer> bookedTickets = new HashMap<>();
    int seatNumber = 1;
    int count = 1;

    public boolean bookTheTicket(String name, String gender, int age, String berthPreference,ClassType classType, String from, String to, String trainName) {
        List<Train> availableTrains = checkTrains(from, to);

        for (Train t : availableTrains) {
            if (trainName.equals(t.getTrainName())) {
                if (isSeatAvailable(t, classType)) {
                    bookSeat(t, classType);
                    Passenger newPassenger = new Passenger(name, gender, age, berthPreference, classType);
                    db.passengers.add(newPassenger);
                    String ticketKey = generateTicketKey(to, classType, seatNumber++, berthPreference);
                    System.out.println("Ticket id: " + ticketKey);
                    bookedTickets.put(ticketKey, count++);
                    return true;
                }
            }
        }
        tempPassengers.add(new Passenger(name, gender, age, berthPreference, classType));
        return false;
    }

    private boolean isSeatAvailable(Train train, ClassType classType) {
        return train.getSeatCount(classType) > 0;
    }

    private void bookSeat(Train train,ClassType classType) {
        train.setSeatCount(classType, train.getSeatCount(classType) - 1);
    }

    public List<Train> checkTrains(String from, String to) {
        List<Train> tempTrain = new ArrayList<>();
        for (Train t : db.getTrains()) {
            if (t.getFromStation().equals(from) && t.getToStation().equals(to)) {
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

    public List<Passenger> getLastPassengerName() {
        if (!db.getPassengers().isEmpty()) {
           return db.getPassengers();
        }
        return null;
    }

    private String generateTicketKey(String destination, ClassType classType, int seatNumber, String berthPreference) {
        return destination + "/" + classType + "/" + seatNumber + "/" + berthPreference;
    }
}
