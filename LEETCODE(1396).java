import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Record or Class to store check-in details
    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Record or Class to accumulate route metrics
    private static class RouteInfo {
        double totalTime;
        int tripCount;

        RouteInfo(double totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    // Map: passenger id -> CheckInInfo
    private final Map<Integer, CheckInInfo> checkInMap;
    // Map: "startStation->endStation" -> RouteInfo
    private final Map<String, RouteInfo> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        // Retrieve and remove customer's check-in record
        CheckInInfo info = checkInMap.remove(id);
        
        String routeKey = info.stationName + "->" + stationName;
        int travelTime = t - info.time;

        // Update route aggregate times and count
        RouteInfo route = routeMap.getOrDefault(routeKey, new RouteInfo(0.0, 0));
        route.totalTime += travelTime;
        route.tripCount += 1;
        
        routeMap.put(routeKey, route);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo route = routeMap.get(routeKey);
        
        return route.totalTime / route.tripCount;
    }
}
