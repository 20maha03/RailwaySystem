import java.util.*;

public class Test {
    public static void main(String[] args) {
        Process p = new Process();
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println("Choose your menu: 1.Book 2.Cancel 3.Print available tickets 4.Print booked tickets 5.Move ticket status 6.Exit");
            String str = input.nextLine();
            
            switch (str) {
                case "1":
                    System.out.println("Enter name:");
                    String name = input.nextLine();
                    System.out.println("Enter age:");
                    int age = input.nextInt();
                    input.nextLine(); 
                    System.out.println("Enter gender:");
                    String gender = input.nextLine();
                    System.out.println("Enter berth preference:");
                    String berthPreference = input.nextLine();
                    System.out.println(p.bookTheTicket(name, gender, age, berthPreference));
                    break;
                case "2":
                    System.out.println("Enter name to cancel:");
                    name = input.nextLine();
                    System.out.println(p.cancelTheTicket(name));
                    System.out.println(p.movedTicketStatus());
                    break;
                case "3":
                    System.out.println("Available tickets:");
                    p.db.getAllPassenger().forEach(System.out::println);
                    break;
                case "4":
                    System.out.println("Booked tickets:");
                    p.tempPassengers.forEach(System.out::println);
                    break;
    
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }
}
