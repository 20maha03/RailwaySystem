import java.util.*;

public class User {
    
    public enum RoleOfTheUser {
        ADMIN, USER
    }

    private String userName;
    private String password;
    private List<String> tickets;
    private RoleOfTheUser role;

    public User() {
        this.tickets = new ArrayList<>();
    }

    public User(String userName, String password, RoleOfTheUser role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.tickets = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public RoleOfTheUser getRole() {
        return role;
    }
    public void addTicket(String ticket) {
        tickets.add(ticket);
    }


    public static RoleOfTheUser getRoleOfTheUser(int roleChoice) {
       if (roleChoice == 1) {
          return RoleOfTheUser.ADMIN;
        }
        else 
        return RoleOfTheUser.USER;
    }
}
    