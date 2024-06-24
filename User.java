import java.util.*;
public class User {
    private String username;
    private String password;
    private List<String> tickets;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.tickets = new ArrayList<>();
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public void addTicket(String ticket) {
        tickets.add(ticket);
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Password: " + password + ", Tickets: " + tickets;
    }
}
