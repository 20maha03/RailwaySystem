import java.util.*;
public class Passenger {
    private String name;
    private String gender;
    private int age;
    private BerthPreference berthPreference;
    private ClassType classType;

    public Passenger(String name, String gender, int age, BerthPreference berthPreference, ClassType classType) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.berthPreference = berthPreference;
        this.classType = classType;
    }

    public String getNameOfThePassenger() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Passenger")
                .append("\r\n")
                .append("name = ").append(name)
                .append(",\r\n")
                .append("gender = ").append(gender)
                .append(",\r\n")
                .append("age = ").append(age)
                .append(",\r\n")
                .append("berth Perference = ").append(berthPreference)
                .append(",\r\n")
                .append("class Type = ").append(classType).append(",\r\n")
                .append("\r\n");
            return sb.toString();
    }
}
