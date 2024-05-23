import java.util.*;

public class Test {
    public static void main(String[] args) {

        RailwayBooking p = new RailwayBooking();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1.Book 2.Cancel 3.Exit");
            String str = input.nextLine();
            switch (str) {
                case "1":
                    System.out.println("Enter from station:");
                    String from = input.nextLine();
                    System.out.println("Enter to station:");
                    String to = input.nextLine();
                    List<Train> trains = p.checkTrains(from, to);
                    if (p.isFind) {
                        System.out.println(trains);
                        System.out.println("enter train name");
                        String trainName = input.nextLine();
                        System.out.println("Enter name:");
                        String name = input.nextLine();
                        System.out.println("Enter age:");
                        int age = input.nextInt();
                        input.nextLine();  
                        System.out.println("Enter gender:");
                        String gender = input.nextLine();
                        System.out.println("Enter berth preference: 1.Upper  2.lower   3.side upper  4.side lower");
                        String preference = input.nextLine();
                        System.out.println("enter classType 1.SL    2.3A    3.2A    4.1A");
                        String classType = input.nextLine();
                        
                        boolean result = p.bookTheTicket(name, gender, age, preference,classType,from,to,trainName);
                        if (result) {
                            System.out.println("Ticket booked successfully "+ name);
                        }
                        else {
                            System.out.println("Sorry, you are on the waiting list");
                        }
                    } 
                    else {
                        System.out.println("Sorry, train not found");
                    }
                    break;
                case "2":
                    System.out.println("Enter name to cancel:");
                    String name = input.nextLine();
                    boolean result = p.cancelTheTicket(name);
                    if (result) {
                        System.out.println("Your ticket is cancelled for " + name);
                    }
                    else {
                         System.out.println("Your ticket is not available in our database");
                    }
                    boolean movResult = p.moveTicketStatus();
                    if (movResult) {
                        String n = p.getLastPassengerName();
                        System.out.println(n + ", your ticket is confirmed");
                    } else {
                        System.out.println("No passengers in the waiting list");
                    }
                    break;
                case "3":
                    System.out.println("Exiting");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}