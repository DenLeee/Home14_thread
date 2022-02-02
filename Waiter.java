public class Waiter extends Thread {
    private final Restaurant restaurant;
    private Status status = Status.FREE;
    public enum Status {
        FREE,
        MAKEORDER,
        BROUGHRANORDER;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Waiter(String name, Restaurant restaurant) {
        super(name);
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Официант {" +
                "имя='" + this.getName() + '\'' + "}";
    }

    @Override
    public void run() {
        restaurant.orederd();
    }
}
