import java.util.*;

public class Route {
    private int routeId;
    private Map<String, Integer> stations;
    private Map<String,Integer> routes;
    private String startStation;
    private String endStation;
   
    public Route(int routeId, Map<String, Integer> stations, String startStation, String endStation) {
        this.routeId = routeId;
        this.stations = stations;
        this.startStation = startStation;
        this.endStation = endStation;
        this.routes = new HashMap<>(stations);
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
    
    public Map<String,Integer> getRoutes() {
        return routes;
    }

    public void setRoutes(Map<String, Integer> routes) {
        this.routes = routes;
    }
    public Map<String, Integer> getAllStation() {
        stations.clear();
        stations.put(startStation, 0);
        int index = 1;
        for (Map.Entry<String, Integer> entry : routes.entrySet()) {
            stations.put(entry.getKey(), index++);
        }
        stations.put(endStation, index);
        System.out.println("maha"+stations);
        return stations;
        
    }

    @Override
    public String toString() {
        return "route Id = " + routeId +
               " routes = " + stations;
    }
}