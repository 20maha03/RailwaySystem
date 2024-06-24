import java.util.*;

public class Train {
    private HashMap<String, Integer> interMediateStation;
    private int totalSeats;
    private String trainName;
    private HashMap<ClassType, HashMap<BerthPreference, Integer>> seatCounts;
    private String dateOfTrain;

    public Train(HashMap<String, Integer> interMediateStation, int totalSeats, String trainName, String dateOfTrain) {
        this.interMediateStation = interMediateStation;
        this.totalSeats = totalSeats;
        this.trainName = trainName;
        this.seatCounts = new HashMap<>();
        this.dateOfTrain = dateOfTrain;

        for (ClassType classType : ClassType.values()) {
            HashMap<BerthPreference, Integer> berthMap = new HashMap<>();
            for (BerthPreference bp : BerthPreference.values()) {
                berthMap.put(bp, 2);
            }
            seatCounts.put(classType, berthMap);
        }
    }

    public HashMap<String, Integer> getInterMediateStation() {
        return interMediateStation;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getDateOfTrain() {
        return dateOfTrain;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getSeatCount(ClassType classType, BerthPreference berthPreference) {
        return seatCounts.get(classType).getOrDefault(berthPreference, 0);
    }

    public void setSeatCount(ClassType classType, BerthPreference berthPreference, int count) {
        seatCounts.get(classType).put(berthPreference, count);
    }
    
    public void setDateOfTrain(String date) {
        this.dateOfTrain = dateOfTrain;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("interMediate station = ").append(interMediateStation)
            .append(", totalSeats = ").append(totalSeats)
            .append(", trainName = ").append(trainName)
            .append(" date = " ).append(dateOfTrain)
            .append(", Available seat counts:");
        for (ClassType ct : ClassType.values()) {
            sb.append(" ").append(ct).append(" {");
            for (BerthPreference bp : BerthPreference.values()) {
                sb.append(" ").append(bp).append(" = ").append(seatCounts.get(ct).get(bp));
            }
            sb.append(" }");
        }
        return sb.toString();
    }
}
