package bestroute;
public class Order {
    private Location consumer;
    private Location restaurant;
    private int prepTime;

    public Order(Location consumer, Location restaurant, int prepTime) {
        this.consumer = consumer;
        this.restaurant = restaurant;
        this.prepTime = prepTime;
    }

    public Location getConsumer() {
        return consumer;
    }

    public Location getRestaurant() {
        return restaurant;
    }

    public int getPrepTime() {
        return prepTime;
    }
}