public class Train {

    private String fromStation;
    private String toStation;
    private int totalSeats;
    private String trainName;
    private int countOfSL;
    private int countOf3A;
    private int countOf2A;
    private int countOf1A;
    

    public Train(String fromStation, String toStation, int totalSeats, String trainName,int countOfSL, int countOf3A, int countOf2A, int countOf1A) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.totalSeats = totalSeats;
        this.trainName = trainName;
        this.countOfSL = countOfSL;
        this.countOf3A = countOf3A;
        this.countOf2A = countOf2A;
        this.countOf1A = countOf1A;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getTrainName() {
        return trainName;
    }
    
    public int getCountOfSL() {
        return countOfSL;
    }
    
    public int getCountOf3A() {
        return countOf3A;
    }

    public int getCountOf2A() {
        return countOf2A;
    }

    public int getCountOf1A() {
        return countOf1A;
    }
    
    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setCountOfSL(int countOfSL) {
        this.countOfSL = countOfSL;
    }
    
    public void setCountOf3A(int countOf3A) {
        this.countOf3A = countOf3A;
    }

    public void setCountOf2A(int countOf2A) {
        this.countOf2A = countOf2A;
    }

    public void setCountOf1A(int countOf1A) {
        this.countOf1A = countOf1A;
    }

    @Override
    public String toString() {
        return
                "fromStation = " + fromStation  +
                " toStation = " + toStation + 
                " totalSeats = " + totalSeats +
                " trainName = " + trainName +
                " Availabe seat count " +
                " SL = " + countOfSL +
                "    3A = " + countOf3A +
                "    2A = " +countOf2A +
                "    1A = " + countOf1A; 

                
    }
}
