package bestroute;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Location {
    String name;
    private double lat;
    private double lon;
    Map<String, Double> distances;

    public Location(String name, double lat, double lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.distances = new HashMap<>();
    }

    public void addDistance(String destination, double distance) {
        this.distances.put(destination, distance);
    }

    public Double getDistance(String destination) {
        return this.distances.get(destination);
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        return Double.compare(location.lat, lat) == 0 &&
                Double.compare(location.lon, lon) == 0 &&
                Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lat, lon);
    }
}
