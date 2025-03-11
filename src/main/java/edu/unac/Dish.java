package edu.unac;

public class Dish {
    public enum DishType {
        APPETIZER, MAIN_COURSE, DESSERT, DRINK
    }

    String name;
    DishType type;
    int quantity;
    double price;

    public Dish(String name, DishType type, int quantity, double price) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }
}

