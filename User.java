import java.util.*;

public class User {
    
    public enum Role{
        ADMIN, USER
    }

    private String userName;
    private String password;
    private List<String> tickets;
    private Role role;

    public User(String userName, String password, Role role) {
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

    public Role getRole() {
        return role;
    }
    public void addTicket(String ticket) {
        tickets.add(ticket);
    }


    public static Role getRole(int roleChoice) {
       if (roleChoice == 1) {
          return Role.ADMIN;
        }
        else 
        return Role.USER;
    }
}
    