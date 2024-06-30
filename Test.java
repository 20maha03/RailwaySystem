import java.util.*;

import java.util.Scanner;

public class Test {
    
    public static void main(String[] args) {
        
        RailwayBooking p = new RailwayBooking();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter username:");
            String username = input.nextLine();
            System.out.println("Enter password:");
            String password = input.nextLine();
            if (p.isAdmin(username, password)) {
                System.out.println("1. Add Train\n2. Delete Train\n3. Add user\n4. Delete user");
                String str = input.nextLine();
                switch (str) {
                    case "1":
                       addTrain(input, p);
                       break;
                    case "2":
                        deleteTrain(input, p);
                        break;
                    case "3":
                        addUser(input, p);
                        break;
                    case "4":
                        deleteUser(input, p);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
            else {
                System.out.println("1. Login and Book\n2. Cancel\n3. View All Booked Passengers\n4. View My Tickets\n5. Exit");
                String str = input.nextLine();
                switch (str) {
                    case "1":
                        bookTicket(username, password, input, p);
                        break;
                    case "2":
                        cancelTicket(input, p);
                        break;
                    case "3":
                        viewAllTicket(p);
                        break;
                    case "4":
                        viewMyTickets(input,p);
                        break;
                    case "5":
                        System.out.println("Exiting...");
                        input.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }
    }
    private static void addTrain(Scanner input, RailwayBooking p) {
        System.out.println("Enter name of the train:");
        String nameOfTheTrain = input.nextLine();
        System.out.println("Enter number of the stations:");
        int numberOfStations = input.nextInt();
        input.nextLine(); 
        String[] arr = new String[numberOfStations];
        HashMap<String, Integer> trainInterMediateStation = new HashMap<>();
        System.out.println("Enter start station");
        String startStation = input.nextLine();
        System.out.println("enter end station");
        String endStation = input.nextLine();
        System.out.println("Enter station names:");
        for (int i = 0; i < numberOfStations; i++) {
            arr[i] = input.nextLine();
        }
        for (int i = 0; i < numberOfStations; i++) {
            trainInterMediateStation.put(arr[i], i);
        }
        System.out.println("Enter available seats:");
        int availableSeats = input.nextInt();
        input.nextLine(); 
        System.out.println("Enter date (YYYY-MM-DD):");
        String dateOfTrain = input.nextLine();
        p.addNewTrain(nameOfTheTrain,startStation, endStation,trainInterMediateStation, availableSeats, dateOfTrain);
    }

    private static void deleteTrain(Scanner input, RailwayBooking p) {
        System.out.println("Enter name of the train:");
        String nameOfTheTrain = input.nextLine();
        p.deleteTrain(nameOfTheTrain);
    }

    private static void bookTicket(String username, String password, Scanner input, RailwayBooking p) {
        if (p.toLogin(username, password)) {
            System.out.println("Enter from station:");
            String from = input.nextLine();
            System.out.println("Enter to station:");
            String to = input.nextLine();
            List<Train> trains = p.checkTrains(from, to);
            System.out.println(trains);
            
            if (trains.size() > 0) {
                System.out.println("Available trains are:");
                for (Train t : trains) {
                    System.out.println(t);
                }
                System.out.println("Enter train name:");
                String trainName = input.nextLine();
                System.out.println("Enter name:");
                String name = input.nextLine();
                System.out.println("Enter age:");
                int age = input.nextInt();
                input.nextLine(); 
                System.out.println("Enter gender:");
                String gender = input.nextLine();
                System.out.println("Enter berth preference: 1.UB, 2.MB, 3.LB, 4.SU, 5.SL");
                int bpChoice = input.nextInt();
                input.nextLine(); 
                BerthPreference berthPreference = getBerthPreference(bpChoice);
                if (berthPreference == null) {
                    System.out.println("Invalid berth preference.");
                    return;
                }
                System.out.println("Enter class type: 1.SL, 2.A3, 3.A2, 4.A1");
                int ctChoice = input.nextInt();
                input.nextLine(); 
                ClassType classType = getClassType(ctChoice);
                if (classType == null) {
                    System.out.println("Invalid class type.");
                    return;
                }
                if (p.bookTheTicket(username, name, gender, age, berthPreference, classType, from, to, trainName)) {
                    System.out.println("Ticket booked successfully.");
                } 
                else {
                    for (Train t : trains) {
                        if (trainName.equals(t.getTrainName())) {
                            System.out.println("Booking failed. Added to waiting list.");
                        }
                    }
                    System.out.println(" in valid train.");
                }
            } 
            else {
                System.out.println("No trains available for the given route.");
            }
        } 
        else {
            System.out.println("Invalid username or password.");
        }
    }

    private static BerthPreference getBerthPreference(int choice) {
        switch (choice) {
            case 1:
                return BerthPreference.UB;
            case 2:
                return BerthPreference.MB;
            case 3:
                return BerthPreference.LB;
            case 4:
                return BerthPreference.SU;
            case 5:
                return BerthPreference.SL;
            default:
                return null;
        }
    }

    private static ClassType getClassType(int choice) {
        switch (choice) {
            case 1:
                return ClassType.SL;
            case 2:
                return ClassType.A3;
            case 3:
                return ClassType.A2;
            case 4:
                return ClassType.A1;
            default:
                return null;
        }
    }

    private static void cancelTicket(Scanner input, RailwayBooking p) {
        System.out.println("Enter the name of the passenger to cancel:");
        String cancelName = input.nextLine();
        if (p.cancelTheTicket(cancelName)) {
            System.out.println("Ticket cancelled successfully.");
        } else {
            System.out.println("Cancellation failed. Passenger not found.");
        }
    }

    private static void viewAllTicket(RailwayBooking p) {
       List<Ticket> tickets = p.getAllTickets();
       List<Ticket> waitListTickets = p.waitingListTickets;
        if (!tickets.isEmpty() && tickets != null ) {
           System.out.println("All Passengers");
           for (int i = 0; i < tickets.size(); i++) {
               System.out.print(tickets.get(i));
           }
           if (!waitListTickets.isEmpty()) {
                System.out.println("All waiting list  Passengers");
                for (int i = 0; i < waitListTickets.size(); i++) {
                    System.out.print(waitListTickets.get(i));
                
                }
            }
        }
       
        else {
            System.out.println("No passengers");
        } 
    }

    private static void viewMyTickets(Scanner input, RailwayBooking p) {
        System.out.println("Enter username:");
        String userToView = input.nextLine();
        System.out.println("Enter password:");
        String passToView = input.nextLine();
        if (p.toLogin(userToView, passToView)) {
            List<String> userTickets = p.getUserTickets(userToView);
            System.out.println("Your Tickets: " + userTickets);
        } 
        else {
            System.out.println("Invalid username or password.");
        }
    }
    
    public static void addUser(Scanner input, RailwayBooking p) {
        System.out.println("Enter user name:");
        String username = input.nextLine();
        System.out.println("Enter password");
        String password = input.nextLine();
        System.out.println("1.Admin/n2.User");
        int roleChoice = input.nextInt();
        input.nextLine(); 
        User.Role role = User.getRole(roleChoice);
        p.addNewUser(username,password,role);
        System.out.println("succussfully added");
    }

    public static void deleteUser(Scanner input, RailwayBooking p) {
        System.out.println("Enter user name:");
        String username = input.nextLine();
        System.out.println("Enter password");
        String password = input.nextLine();
        p.deleteUser(username,password);
        System.out.println("succussfully deleted");
    }
}
