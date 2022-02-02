public class Visitor extends Thread {
    private Restaurant restaurant;

    public Visitor(String name, Restaurant restaurant) {
        super(name);
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "restaurant=" + restaurant +
                '}';
    }

    @Override
    public void run() {
        restaurant.makeAnOrder();
    }
}
