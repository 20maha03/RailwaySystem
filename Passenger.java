public class Passenger {

        private String nameOfThePassenger;
        private String genderOfThePassenger;
        private int ageOfThePassenger;
        private String berthPreference;
        private String classType;

        public Passenger (String nameOfThePassenger, String genderOfThePassenger, int ageOfThePassenger, String berthPreference,String classType) {
            this.nameOfThePassenger = nameOfThePassenger;
            this.ageOfThePassenger = ageOfThePassenger;
            this.genderOfThePassenger = genderOfThePassenger;
            this.berthPreference = berthPreference;
            this.classType = classType;
        }

        public void setNameOfThePassenger (String nameOfThePassenger) {
            this.nameOfThePassenger = nameOfThePassenger;
        }

        public void setAgeOfThePassenger (int ageOfThePassenger) {
            this.ageOfThePassenger = ageOfThePassenger;
        }

        public void setBerthPreference (String berthPreference) {
            this.berthPreference = berthPreference;
        }

        public void setGenderOfThePassenger (String genderOfThePassenger) {
            this.genderOfThePassenger = genderOfThePassenger;
        }

        public void setClassType(String classType) {
            this.classType = classType;
        }

        public String getNameOfThePassenger () {
            return nameOfThePassenger;
        }

        public int getAgeOfThePassenger () {
            return ageOfThePassenger;
        }

        public String getGenderOfThePassenger () {
            return genderOfThePassenger;
        }

        public String getBerthPreference () {
            return berthPreference;
        }

        public String getClassType () {
            return classType;
        }
        
        @Override
        public String toString() {
            return "name : " + getNameOfThePassenger() +
                    " age : " + getAgeOfThePassenger() +
                    " gender : " + getGenderOfThePassenger() +
                    " berth preference : " + getBerthPreference() +
                    " class type : " + getClassType();
        }
}