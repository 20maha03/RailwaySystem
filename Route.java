import java.util.HashMap;
import java.util.Map;

public class Route {
    private int routeId;
    private Map<String,Integer> routesOfTheTrain;

    public Route(int routeId, Map<String,Integer> routesOfTheTrain) {
        this.routeId = routeId;
        this.routesOfTheTrain = routesOfTheTrain;
    } 

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public void setRoutesOfTheTrain(Map<String,Integer> routesOfTheTrain) {
        this.routesOfTheTrain = routesOfTheTrain;
    }

    public int getRouteId() {
        return routeId;
    }

    public Map<String,Integer> getRoutesOfTheTrain() {
        return routesOfTheTrain;
    }

    @Override
    public String toString() {
        return "route Id = " +routeId +
               " routes = " +routesOfTheTrain;
    }
}
