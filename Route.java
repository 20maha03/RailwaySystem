import java.util.HashMap;
import java.util.Map;

public class Route {
    private int routeId;
    private Map<String,Integer> stations;

    public Route(int routeId, Map<String,Integer> stations) {
        this.routeId = routeId;
        this.stations = stations;
    } 

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setStations(Map<String,Integer> stations) {
        this.stations = stations;
    }

    public int getRouteId() {
        return routeId;
    }

    public void addStation() {

    }

    public Map<String,Integer> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        return "route Id = " +routeId +
               " routes = " +stations;
    }
}
