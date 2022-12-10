package coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private Queue<Order> queueOfNumber = new LinkedList<>();
    private int lastOrderNumber = 1;

    public void add(String name) {
        queueOfNumber.add(new Order(name, lastOrderNumber++));
    }

    public Order deliver() {
        return queueOfNumber.poll();
    }

    public Order deliver(int number) {
        Order order;
        for (Order order1 : queueOfNumber){
          if(order1.getNumber() == number) {
              order = order1;
              queueOfNumber.remove(order1);
              return order;
          }
        }
        return null;
    }

    public void draw() {
        System.out.println("=================\nNum   |   Name");
        for (Order order : queueOfNumber) {
            System.out.println(order.getNumber() + "     |   " + order.getName());
        }
    }
}
