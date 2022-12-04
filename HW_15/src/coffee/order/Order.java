package coffee.order;

public class Order {
    private final String name;
    private final Integer orderNumber;

    public Order(String name, Integer orderNumber) {
        this.name = name;
        this.orderNumber = orderNumber;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return orderNumber;
    }
}
