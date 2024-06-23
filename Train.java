import java.util.EnumMap;

public class Train {

    private String fromStation;
    private String interMediateStation1;
    private String interMediateStation2;
    private String toStation;
    private int totalSeats;
    private String trainName;
    private EnumMap<ClassType, EnumMap<BerthPreference, Integer>> seatCounts;

    public Train(String fromStation, String interMediateStation1,String interMediateStation2, String toStation, int totalSeats, String trainName) {
        this.fromStation = fromStation;
        this.interMediateStation1 = interMediateStation1;
        this.interMediateStation2 = interMediateStation2;
        this.toStation = toStation;
        this.totalSeats = totalSeats;
        this.trainName = trainName;
        this.seatCounts = new EnumMap<>(ClassType.class);

        for (ClassType classType : ClassType.values()) {
            EnumMap<BerthPreference, Integer> berthMap = new EnumMap<>(BerthPreference.class);
            for (BerthPreference bp : BerthPreference.values()) {
                berthMap.put(bp, 2); 
            }
            seatCounts.put(classType, berthMap);
        }
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getInterMediateStation1() {
        return interMediateStation1;
    }

    public String getInterMediateStation2() {
        return interMediateStation2;
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

    public int getSeatCount(ClassType classType, BerthPreference berthPreference) {
        return seatCounts.get(classType).getOrDefault(berthPreference, 0);
    }

    public void setSeatCount(ClassType classType, BerthPreference berthPreference, int count) {
        seatCounts.get(classType).put(berthPreference, count);
    }
    
    public void setInterMediateStation1(String interMediateStation1) {
        this.interMediateStation1 = interMediateStation1;
    }

    public void setInterMediateStation2(String interMediateStation2) {
        this.interMediateStation2 = interMediateStation2;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fromStation = ").append(fromStation)
                .append(" toStation = ").append(toStation)
                .append(" totalSeats = ").append(totalSeats)
                .append(" trainName = ").append(trainName)
                .append(" Available seat counts:");
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
