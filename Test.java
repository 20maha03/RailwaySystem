import java.util.*;

public class Test {
    public static void main(String[] args) {

        RailwayBooking p = new RailwayBooking();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1.Book 2.Cancel 3.View All Booked Passenger 4.Exit");
            String str = input.nextLine();
            switch (str) {
                case "1":
                    System.out.println("Enter from station:");
                    String from = input.nextLine();
                    System.out.println("Enter to station:");
                    String to = input.nextLine();
                    List<Train> trains = p.checkTrains(from, to);
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
                        BerthPreference berthPreference = null;
                        switch (bpChoice) {
                            case 1:
                                berthPreference = BerthPreference.UB;
                                break;
                            case 2:
                                berthPreference = BerthPreference.MB;
                                break;
                            case 3:
                                berthPreference = BerthPreference.LB;
                                break;
                            case 4:
                                berthPreference = BerthPreference.SU;
                                break;
                            case 5:
                                berthPreference = BerthPreference.SL;
                                break;
                            default:
                                System.out.println("Invalid berth preference.");
                                continue;
                        }

                        System.out.println("Enter class type: 1.SL, 2.A3, 3.A2, 4.A1");
                        int ctChoice = input.nextInt();
                        input.nextLine();
                        ClassType classType = null;
                        switch (ctChoice) {
                            case 1:
                                classType = ClassType.SL;
                                break;
                            case 2:
                                classType = ClassType.A3;
                                break;
                            case 3:
                                classType = ClassType.A2;
                                break;
                            case 4:
                                classType = ClassType.A1;
                                break;
                            default:
                                System.out.println("Invalid class type.");
                                continue;
                        }

                        if (p.bookTheTicket(name, gender, age, berthPreference, classType, from, to, trainName)) {
                            System.out.println("Ticket booked successfully.");
                        } else {
                            System.out.println("Booking failed. Added to waiting list.");
                        }
                    } else {
                        System.out.println("No trains available for the given route.");
                    }
                    break;
                case "2":
                    System.out.println("Enter the name of the passenger to cancel:");
                    String cancelName = input.nextLine();
                    if (p.cancelTheTicket(cancelName)) {
                        System.out.println("Ticket cancelled successfully.");
                    } else {
                        System.out.println("Cancellation failed. Passenger not found.");
                    }
                    break;
                case "3":
                    List<Passenger> passengers = p.getAllPassenger();
                    if (passengers != null) {
                        System.out.println("Passengers List: " + passengers);
                    } else {
                        System.out.println("No passengers found.");
                    }
                    break;
                case "4":
                    System.out.println("Exiting...");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
