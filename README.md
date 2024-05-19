# BestRoute

# Delivery Optimization

This Java program optimizes delivery routes for a set of orders based on their preparation times and distances between locations.

## Features

- Calculates the best delivery route among predefined routes.
- Considers the preparation times of orders to optimize the delivery sequence.
- Utilizes the Haversine formula to calculate distances between locations on the Earth's surface.
- Supports defining custom locations and orders with preparation times.
- Allows manual adjustment of distances between locations.

## Usage

1. Clone or download the repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Modify the `DeliveryOptimization.java` file to define your locations and orders.
4. Run the `DeliveryOptimization` class to find the best delivery route.

## Project Structure

- `DeliveryOptimization.java`: Main class containing the optimization logic and entry point of the program.
- `Location.java`: Class representing a location with its name, latitude, longitude, and distances to other locations.
- `Order.java`: Class representing an order with the customer location, restaurant location, and preparation time.
- `CalculateDistance.java`: Class containing methods to calculate distances between locations using the Haversine formula.

## Customization

- Adjust the coordinates and distances between locations to reflect your delivery network.
- Define orders with different preparation times to test the optimization under various scenarios.
- Explore different route permutations or implement additional optimization strategies.

## Dependencies

This project has no external dependencies beyond the Java standard library.










main(String[] args): This method is the entry point of the program. It initializes the locations, orders, and distances between locations, then iterates through all possible routes to find the best delivery route based on the shortest total time.

calculateTotalTime(String[] route, Location Aman, Location R1, Location R2, Location C1, Location C2, Order order1, Order order2): This method calculates the total time required to complete a given route. It considers the travel time between locations and the preparation times of the orders. The route array contains the sequence of locations to visit. It returns the total time taken to complete the route.

getLocationByName(String name, Location... locations): This method retrieves a location object by its name from an array of locations. It is used to find the location object corresponding to a given name.

travelTime(double distance): This method calculates the travel time based on the distance traveled. It converts the distance from kilometers to minutes using the predefined speed constant (SPEED) of the delivery vehicles.

The methods in the Location and Order classes:

addDistance(String destination, double distance): This method adds the distance between the current location and a destination location to the distances map. It is used to define the distances between locations in the delivery network.

getDistance(String destination): This method retrieves the distance to a destination location from the distances map. It returns the distance as a double value.

getCustomer(): This method returns the customer location of the order.

getRestaurant(): This method returns the restaurant location of the order.

getPrepTime(): This method returns the preparation time required for the order.
