import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Restaurant {
    public ArrayList<Visitor> visitors = new ArrayList<>();
    public ArrayList<Waiter> waiters = new ArrayList<>();
    private AtomicInteger orderCount = new AtomicInteger(0);

    public synchronized void makeAnOrder () {
        String name = Thread.currentThread().getName();
        System.out.println(name + " делает заказ...");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {}

        System.out.println(name + " сделал заказ");
        orderCount.incrementAndGet();
        try {
            wait();
        } catch (InterruptedException e) {}

        System.out.println(name + " кушает");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {}

        System.out.println(name + " уходит сытым");
    }

    public synchronized void orederd() {
        String name = Thread.currentThread().getName();
        if (orderCount.compareAndSet(0,0)) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        while (!orderCount.compareAndSet(0,0)) {
            System.out.println(name + " заказ принял");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
            System.out.println(name + " принес заказ");
            orderCount.decrementAndGet();
            notify();
        }
    }

    public static long getTime() {
        long time = new Random().nextInt(10000);
        return (time < 100) ? time*100 : (time < 1000) ? time*10 : time;
    }
}
