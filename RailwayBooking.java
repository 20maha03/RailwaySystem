import java.util.*;

public class RailwayBooking {

    private DataBase db = new DataBase();
    public List<Passenger> tempPassengers = new ArrayList<>();
    public HashMap<String, Integer> bookedTickets = new HashMap<>();
    int seatNumber = 1;
    int count = 1;

    public boolean bookTheTicket(String name, String gender, int age, BerthPreference berthPreference, ClassType classType, String from, String to, String trainName) {
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
                    return true;
                } else {
                    for (BerthPreference bp : BerthPreference.values()) {
                        if (bp != berthPreference && isSeatAvailable(t, classType, bp)) {
                            bookSeat(t, classType, bp);
                            Passenger newPassenger = new Passenger(name, gender, age, bp, classType);
                            db.passengers.add(newPassenger);
                            String ticketKey = generateTicketKey(to, classType, seatNumber++, bp);
                            System.out.println("Ticket id: " + ticketKey);
                            bookedTickets.put(ticketKey, count++);
                            return true;
                        }
                    }
                }
            }
        }
        tempPassengers.add(new Passenger(name, gender, age, berthPreference, classType));
        return false;
    }

    private boolean isSeatAvailable(Train train, ClassType classType, BerthPreference berthPreference) {
        return train.getSeatCount(classType, berthPreference) > 0;
    }

    private void bookSeat(Train train, ClassType classType, BerthPreference berthPreference) {
        train.setSeatCount(classType, berthPreference, train.getSeatCount(classType, berthPreference) - 1);
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

    private String generateTicketKey(String destination, ClassType classType, int seatNumber, BerthPreference berthPreference) {
        return destination + "/" + classType + "/" + seatNumber + "/" + berthPreference;
    }
}
