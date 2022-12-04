package coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private Queue<Order> queueOfNumber = new LinkedList<>();
    private int lastOrderNumber = 1;

    public void add(String name) {
        queueOfNumber.add(new Order(name, lastOrderNumber++));
    }

    public void deliver() {
        queueOfNumber.poll();
    }
    public void deliver(int number) {
        queueOfNumber.removeIf(n -> (n.getNumber() == number));
    }

    public void draw() {
        System.out.println("=================\nNum   |   Name");
        for (Order order : queueOfNumber) {
            System.out.println(order.getNumber() + "     |   " + order.getName());
        }
    }
}
