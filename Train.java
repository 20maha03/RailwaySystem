import java.util.*;

public class Train {
    private String fromStation;
    private String toStation;
    private int totalSeats;
    private String trainName;
    private EnumMap<ClassType, Integer> seatCounts;

    public Train(String fromStation, String toStation, int totalSeats, String trainName, int countOfSL, int countOfA3, int countOfA2, int countOfA1) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.totalSeats = totalSeats;
        this.trainName = trainName;
        this.seatCounts = new EnumMap<>(ClassType.class);
        seatCounts.put(ClassType.SL, countOfSL);
        seatCounts.put(ClassType.A3, countOfA3);
        seatCounts.put(ClassType.A2, countOfA2);
        seatCounts.put(ClassType.A1, countOfA1);
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

    public int getSeatCount(ClassType classType) {
        return seatCounts.getOrDefault(classType, 0);
    }

    public void setSeatCount(ClassType classType, int count) {
        seatCounts.put(classType, count);
    }

    @Override
    public String toString() {
        return 
                "fromStation='" + fromStation + 
                ", toStation='" + toStation + 
                ", totalSeats=" + totalSeats +
                ", trainName='" + trainName + 
                ", SL=" + seatCounts.get(ClassType.SL) +
                ", A3=" + seatCounts.get(ClassType.A3) +
                ", A2=" + seatCounts.get(ClassType.A2) +
                ", A1=" + seatCounts.get(ClassType.A1) ;               
    }
}
