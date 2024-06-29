import java.util.*;

public class Route {
    private int routeId;
    private Map<String, Integer> stations;
    private String startStation;
    private String endStation;
    public Route() {
        
    }
    public Route(int routeId, Map<String, Integer> stations, String startStation, String endStation) {
        this.routeId = routeId;
        this.stations = stations;
        this.startStation = startStation;
        this.endStation = endStation;
    } 

    public int getRouteId() {
        return routeId;
    }

    public String getStartStation() {
        return startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public Map<String, Integer> getAllStation() {
        stations.clear();
        stations.put(startStation, 0);
        int index = 1;
        for (Map.Entry<String, Integer> entry : stations.entrySet()) {
            stations.put(entry.getKey(), index++);
        }
        stations.put(endStation, index);
        return stations;
    }

    @Override
    public String toString() {
        return "route Id = " + routeId +
               " routes = " + stations;
    }
}