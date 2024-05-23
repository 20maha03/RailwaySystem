import java.util.*;

public class RailwayBooking {
    DataBase db = new DataBase();
    public boolean isFind = false;
    public List<Passenger> tempPassengers = new ArrayList<>();

    public String bookTheTicket(String name, String gender, int age, String berthPreference, String classType, String from, String to) {
        List<Train> availableTrains = checkTrains(from, to);
        for (Train t : availableTrains) {
            if (isSeatAvailable(t, classType)) {
                bookSeat(t, classType);
                Passenger newPassenger = new Passenger(name, gender, age, berthPreference, classType);
                db.passengers.add(newPassenger);
                return "Ticket booked successfully for " + name;
            }
        }
        tempPassengers.add(new Passenger(name, gender, age, berthPreference, classType));
        return "Sorry, you are on the waiting list";
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
        isFind = false;
        List<Train> tempTrain = new ArrayList<>();
        for (Train t : db.getTrains()) {
            if (t.getFromStation().equals(from) && t.getToStation().equals(to)) {
                isFind = true;
                tempTrain.add(t);
            }
        }
        return tempTrain;
    }

    public String cancelTheTicket(String name) {
        for (Passenger e : db.getPassengers()) {
            if (name.equals(e.getNameOfThePassenger())) {
                db.passengers.remove(e);
                return "Your ticket is cancelled for " + name;
            }
        }
        return "Your ticket is not available in our database";
    }

    public String moveTicketStatus() {
        if (!tempPassengers.isEmpty()) {
            Passenger passenger = tempPassengers.remove(0);
            db.passengers.add(passenger);
            return passenger.getNameOfThePassenger() + "'s ticket is confirmed";
        }
        return "No passengers in the waiting list";
    }
}
