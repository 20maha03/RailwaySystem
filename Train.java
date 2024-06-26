import java.util.*;

public class Train {
    private String trainName;
    private int trainId;
    private int totalSeats;
    private HashMap<ClassType, HashMap<BerthPreference, Integer>> seatCounts;
    private String dateOfTrain;

    public Train(String trainName, int trainId, int totalSeats,String dateOfTrain) {
        this.trainName = trainName;
        this.trainId = trainId;
        this.totalSeats = totalSeats;
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

    public int getTrainId() {
        return trainId;
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
        sb.append("trainName = ").append(trainName)
            .append(",\r\n")
            .append(" train id = ").append(trainId)
            .append(",\r\n")
            .append("totalSeats = ").append(totalSeats)
            .append(",\r\n")
            .append("date = " ).append(dateOfTrain)
            .append(",\r\n")
            .append("Available seat counts:");
        for (ClassType ct : ClassType.values()) {
            sb.append(" ").append(ct).append(" {");
            for (BerthPreference bp : BerthPreference.values()) {
                sb.append(" ").append(bp).append(" = ").append(seatCounts.get(ct).get(bp));
            }
            sb.append(" }");
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
