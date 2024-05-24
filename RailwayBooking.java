import java.util.*;

public class RailwayBooking {

    private DataBase db = new DataBase();
    public List<Passenger> tempPassengers = new ArrayList<>();
    public HashMap <String,Integer> bookedTickets = new HashMap<>();
    int seatNumber = 1;
    int count = 1;
    public boolean bookTheTicket(String name, String gender, int age, String berthPreference, String classType, String from, String to,String trainName) {
        List<Train> availableTrains = checkTrains(from, to);
       
        for (Train t : availableTrains) {
            if (trainName.equals(t.getTrainName())) {
                if (isSeatAvailable(t, classType)) {
                    bookSeat(t, classType);
                    Passenger newPassenger = new Passenger(name, gender, age, berthPreference, classType);
                    db.passengers.add(newPassenger);
                    String ticketKey = generateTicketKey(to, classType, seatNumber++, berthPreference);
                    System.out.println("Ticket id: "+ticketKey);
                    bookedTickets.put(ticketKey,count++);
                    return true;
                }
            }
        }
        tempPassengers.add(new Passenger(name, gender, age, berthPreference, classType));
        return false;
    }

    private boolean isSeatAvailable(Train train, String classType) {
        switch (classType) {
            case "SL":
                return train.getCountOfSL() > 0;
            case "3A":
                return train.getCountOf3A() > 0;
            case "2A":
                return train.getCountOf2A() > 0;
            case "1A":
                return train.getCountOf1A() > 0;
            default:
                return false;
        }
    }

    private void bookSeat(Train train, String classType) {
        switch (classType) {
            case "SL":
                train.setCountOfSL(train.getCountOfSL() - 1);
                break;
            case "3A":
                train.setCountOf3A(train.getCountOf3A() - 1);
                break;
            case "2A":
                train.setCountOf2A(train.getCountOf2A() - 1);
                break;
            case "1A":
                train.setCountOf1A(train.getCountOf1A() - 1);
                break;
        }
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
    public String getLastPassengerName() {
        if (!db.getPassengers().isEmpty()) {
            return db.getPassengers().get(db.getPassengers().size() - 1).getNameOfThePassenger();
        }
        return null;
    }

    private String generateTicketKey(String destination, String classType, int seatNumber, String berthPreference) {
        return destination + "/" + classType + "/" + seatNumber + "/" + berthPreference;
    }
}
