class Passenger {
    private String nameOfThePassenger;
    private String genderOfThePassenger;
    private int ageOfThePassenger;
    private String berthPreference;
    private ClassType classType;

    public Passenger(String nameOfThePassenger, String genderOfThePassenger, int ageOfThePassenger, String berthPreference, ClassType classType) {
        this.nameOfThePassenger = nameOfThePassenger;
        this.genderOfThePassenger = genderOfThePassenger;
        this.ageOfThePassenger = ageOfThePassenger;
        this.berthPreference = berthPreference;
        this.classType = classType;
    }

    public void setNameOfThePassenger(String nameOfThePassenger) {
        this.nameOfThePassenger = nameOfThePassenger;
    }

    public void setAgeOfThePassenger(int ageOfThePassenger) {
        this.ageOfThePassenger = ageOfThePassenger;
    }

    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }

    public void setGenderOfThePassenger(String genderOfThePassenger) {
        this.genderOfThePassenger = genderOfThePassenger;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public String getNameOfThePassenger() {
        return nameOfThePassenger;
    }

    public int getAgeOfThePassenger() {
        return ageOfThePassenger;
    }

    public String getGenderOfThePassenger() {
        return genderOfThePassenger;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public ClassType getClassType() {
        return classType;
    }

    @Override
    public String toString() {
        return 
                "nameOfThePassenger='" + nameOfThePassenger + '\'' +
                ", genderOfThePassenger='" + genderOfThePassenger + '\'' +
                ", ageOfThePassenger=" + ageOfThePassenger +
                ", berthPreference='" + berthPreference + '\'' +
                ", classType=" + classType ;
                
    }
}
