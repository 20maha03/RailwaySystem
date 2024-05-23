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
                        System.out.println("Enter name:");
                        String name = input.nextLine();
                        System.out.println("Enter age:");
                        int age = input.nextInt();
                        input.nextLine();  
                        System.out.println("Enter gender:");
                        String gender = input.nextLine();
                        System.out.println("Enter berth preference:");
                        String preference = input.nextLine();
                        System.out.println("enter classType:");
                        String classType = input.nextLine();
                        String result = p.bookTheTicket(name, gender, age, preference,classType,from,to);
                        System.out.println(result);
                    } 
                    else {
                        System.out.println("Sorry, train not found");
                    }
                    break;
                case "2":
                    System.out.println("Enter name to cancel:");
                    String name = input.nextLine();
                    String result = p.cancelTheTicket(name);
                    System.out.println(result);
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