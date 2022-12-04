package coffee.order;

public class Main {

    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Anna");
        coffeeOrderBoard.add("Vlad");
        coffeeOrderBoard.add("Kate");
        coffeeOrderBoard.add("Andrey");
        coffeeOrderBoard.add("Vitaliy");

        coffeeOrderBoard.deliver(4);
        coffeeOrderBoard.deliver();

        coffeeOrderBoard.draw();
    }
}
