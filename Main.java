public class Main {
    public static final int VISITOR_COUNT = 10;
    public static final int WAITER_COUNT = 2;

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        for (int i = 1; i <= VISITOR_COUNT; i++) {
            restaurant.visitors.add(new Visitor("Посетитель-" + i, restaurant));
        }
        for (int i = 1; i <= WAITER_COUNT; i++) {
            restaurant.waiters.add(new Waiter("Официант-" + i, restaurant));
        }

        for (Visitor visitor: restaurant.visitors) {
            visitor.start();
        }
        for (Waiter waiter: restaurant.waiters) {
            waiter.start();
        }

    }
}
