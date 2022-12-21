package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(534045, Type.BOOK, 25, true, LocalDate.now()));
        list.add(new Product(235446, Type.BOOK, 15, true, LocalDate.now()));
        list.add(new Product(234567, Type.TOY, 50, false, LocalDate.now()));
        list.add(new Product(765432, Type.BOOK, 35, false, LocalDate.now()));
        list.add(new Product(456789, Type.BOOK, 45, true, LocalDate.now()));

        System.out.println(getBook(list));
        System.out.println();

        System.out.println(getBookWithDiscount(list));
        System.out.println();

        System.out.println(getTheCheapestBook(list));
        System.out.println();

        System.out.println(getThreeLastProducts(list));
        System.out.println();

        System.out.println(getSumarise(list));
        System.out.println();

        System.out.println(getMap(list));
    }

    //1.2
    public static List<Product> getBook(List<Product> list) {
        return list.stream().filter(element ->
                        element.getType().equals(Type.BOOK) && element.getCost() > 250)
                .toList();
    }

    //2.2
    public static List<Product> getBookWithDiscount(List<Product> list) {
        return list.stream().filter(element -> element.getType().equals(Type.BOOK)
                        && element.isDiscount())
                .peek((element -> element.setCost(element.getCost() * 0.9))).toList();
    }

    //3.2
    public static Product getTheCheapestBook(List<Product> list) {
        return list.stream().filter(element -> element.getType().equals(Type.BOOK))
                .min(Comparator.comparing(Product::getCost))
                .orElseThrow(() -> new IllegalArgumentException("Product [Category - Book] not found"));
    }

    // 4.2
    public static List<Product> getThreeLastProducts(List<Product> list) {
        return list.stream().sorted(Comparator.comparing(Product::getNow))
                .skip(list.size() - 3).collect(Collectors.toList());
    }

    // 5.2
    public static double getSumarise(List<Product> list) {
        return list.stream().filter(element -> element.getNow().getYear() == LocalDate.now().getYear()
                && element.getType().equals(Type.BOOK) && element.getCost() <= 75).mapToDouble(Product::getCost).sum();
    }

    // 6.2
    public static Map<Type, List<Product>> getMap(List<Product> list) {
        return list.stream().collect(Collectors.groupingBy(Product::getType));
    }
}
