package bestroute;

public class DeliveryOptimization {
    private static final double SPEED = 20.0; // km/h

    public static void main(String[] args) {
        // Define locations and Adjust coordinates
        Location Aman = new Location("Aman", 12.9344, 77.6091);
        Location R1 = new Location("R1", 12.9444, 77.6191);
        Location C1 = new Location("C1", 12.9454, 77.6228);
        Location R2 = new Location("R2", 12.9369, 77.6271);
        Location C2 = new Location("C2", 12.9401, 77.6215);

        // Define orders with preparation times
        Order order1 = new Order(C1, R1, 10);
        Order order2 = new Order(C2, R2, 15);


        // Calculate and define distances using Haversine formula
//        CalculateDistance calculateDistance = new CalculateDistance();
//        Aman.addDistance("R1", calculateDistance.haversine(Aman.getLat(), Aman.getLon(), R1.getLat(), R1.getLon()));
//        Aman.addDistance("R2", calculateDistance.haversine(Aman.getLat(), Aman.getLon(), R2.getLat(), R2.getLon()));
//        R1.addDistance("C1", calculateDistance.haversine(R1.getLat(), R1.getLon(), C1.getLat(), C1.getLon()));
//        R1.addDistance("C2", calculateDistance.haversine(R1.getLat(), R1.getLon(), C2.getLat(), C2.getLon()));
//        R1.addDistance("R2", calculateDistance.haversine(R1.getLat(), R1.getLon(), R2.getLat(), R2.getLon()));
//        R2.addDistance("C1", calculateDistance.haversine(R2.getLat(), R2.getLon(), C1.getLat(), C1.getLon()));
//        R2.addDistance("C2", calculateDistance.haversine(R2.getLat(), R2.getLon(), C2.getLat(), C2.getLon()));
//        C1.addDistance("C2", calculateDistance.haversine(C1.getLat(), C1.getLon(), C2.getLat(), C2.getLon()));


        // Manually set distances based on the graph to test it better
        Aman.addDistance("R1", 10);
        Aman.addDistance("R2", 7);
        R1.addDistance("C1", 3);
        R1.addDistance("C2", 4);
        R1.addDistance("R2", 6);
        R2.addDistance("C1", 4);
        R2.addDistance("C2", 7);
        C1.addDistance("C2", 4);

        // Possible routes based on the graph
        String[][] routes = {
                {"Aman", "R1", "C1", "R2", "C2"},
                {"Aman", "R1", "R2", "C2", "C1"},
                {"Aman", "R2", "R1", "C1", "C2"},
                {"Aman", "R1", "R2", "C1", "C2"},
                {"Aman", "R2", "R1", "C2", "C1"},
                {"Aman", "R2", "C2", "R1", "C1"}
        };

        double bestTime = Double.MAX_VALUE;
        String[] bestRoute = null;

        // Iterate through all possible routes
        for (String[] route : routes) {
            double totalTime = calculateTotalTime(route, Aman, R1, R2, C1, C2, order1, order2);
            if (totalTime < bestTime) {
                bestTime = totalTime;
                bestRoute = route;
            }
        }

        System.out.println("Best Route: " + String.join(" -> ", bestRoute) + " with total time: " + bestTime + " minutes");
    }

    private static double calculateTotalTime(String[] route, Location Aman, Location R1, Location R2, Location C1, Location C2, Order order1, Order order2) {
        double totalTime = 0;
        Location currentLocation = Aman;
        Order firstOrder; // The order with shorter preparation time
        Order secondOrder; // The order with longer preparation time

        // Determine which order to deliver first based on preparation times
        if (order1.getPrepTime() <= order2.getPrepTime()) {
            firstOrder = order1;
            secondOrder = order2;
        } else {
            firstOrder = order2;
            secondOrder = order1;
        }

        for (int i = 1; i < route.length; i++) {
            Location nextLocation = getLocationByName(route[i], Aman, R1, R2, C1, C2);
            if (currentLocation.getDistance(nextLocation.name) == null) continue;
            totalTime += travelTime(currentLocation.getDistance(nextLocation.name));

            // If the next location is the restaurant of the first order, add its preparation time
            if (nextLocation.equals(firstOrder.getRestaurant())) {
                totalTime += firstOrder.getPrepTime();
            }
            // If the next location is the restaurant of the second order, and the preparation time
            // of the first order has already passed, add its preparation time
            else if (nextLocation.equals(secondOrder.getRestaurant()) && totalTime >= firstOrder.getPrepTime()) {
                totalTime += secondOrder.getPrepTime();
            }

            currentLocation = nextLocation;
        }

        return totalTime;
    }


    private static Location getLocationByName(String name, Location... locations) {
        for (Location location : locations) {
            if (location.name.equals(name)) {
                return location;
            }
        }
        return null;
    }

    private static double travelTime(double distance) {
        // Convert speed to km/min and calculate travel time
        return distance / (SPEED / 60);
    }


}
