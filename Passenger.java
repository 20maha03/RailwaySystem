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
        return "Passenger" +
                "name='" + name +
                ", gender='" + gender + 
                ", age=" + age +
                ", berthPreference=" + berthPreference +
                ", classType=" + classType;
    }
}
