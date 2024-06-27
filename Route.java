import java.util.HashMap;
import java.util.Map;

public class Route {
    private int routeId;
    private Map<String, Integer> stations;
    private Map<String, Integer> map;
    private String startStation;
    private String endStation;

    public Route(int routeId, Map<String, Integer> stations, String startStation, String endStation) {
        this.routeId = routeId;
        this.stations = stations;
        this.startStation = startStation;
        this.endStation = endStation;
        this.map = new HashMap<>();
    } 

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setStations(Map<String, Integer> stations) {
        this.stations = stations;
    }

    public int getRouteId() {
        return routeId;
    }

    public void addStation(String stationName, int id) {
        stations.put(stationName, id);
    }

    public void deleteStation(String stationName) {
        stations.remove(stationName);
    }

    public Map<String, Integer> getStations() {
        return stations;
    }

    public Map<String, Integer> getAllStation() {
        map.clear();
        map.put(startStation, 0);
        int index = 1;
        for (Map.Entry<String, Integer> entry : stations.entrySet()) {
            map.put(entry.getKey(), index++);
        }
        map.put(endStation, index);
        return map;
    }

    @Override
    public String toString() {
        return "route Id = " + routeId +
               " routes = " + stations;
    }
}