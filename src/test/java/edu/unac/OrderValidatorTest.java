package edu.unac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderValidatorTest {
    @Test
    void testNullOrder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                OrderValidator.validateAndCalculateTotal(null)
        );
        assertEquals("The order cannot be empty.", exception.getMessage());
    }

    @Test
    void testEmptyOrder() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                OrderValidator.validateAndCalculateTotal(List.of())
        );
        assertEquals("The order cannot be empty.", exception.getMessage());
    }

    @Test
    void testDishWithNameNull() {
        List<Dish> order = List.of(new Dish(null, Dish.DishType.MAIN_COURSE, 1, 100));
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                OrderValidator.validateAndCalculateTotal(order)
        );
        assertEquals("The dish name cannot be empty.", exception.getMessage());
    }

    @Test
    void testDishWithoutName() {
        List<Dish> order = List.of(new Dish("", Dish.DishType.MAIN_COURSE, 1, 100));
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                OrderValidator.validateAndCalculateTotal(order)
        );
        assertEquals("The dish name cannot be empty.", exception.getMessage());
    }

    @Test
    void testDishWithNegativeQuantity() {
        List<Dish> order = List.of(new Dish("Pasta", Dish.DishType.MAIN_COURSE, -1, 50));
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                OrderValidator.validateAndCalculateTotal(order)
        );
        assertEquals("The dish quantity must be at least 1.", exception.getMessage());
    }

    @Test
    void testDishWithNegativePrice() {
        List<Dish> order = List.of(new Dish("Pasta", Dish.DishType.MAIN_COURSE, 1, -50));
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                OrderValidator.validateAndCalculateTotal(order)
        );
        assertEquals("The dish price must be positive.", exception.getMessage());
    }

    @Test
    void testOrderWithoutMainCourse() {
        List<Dish> order = List.of(
                new Dish("Soup", Dish.DishType.APPETIZER, 1, 50),
                new Dish("Cake", Dish.DishType.DESSERT, 1, 30)
        );

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                OrderValidator.validateAndCalculateTotal(order)
        );

        assertEquals("The order must contain at least one main course dish.", exception.getMessage());
    }

    @Test
    void testOrderWithoutDiscount() {
        List<Dish> order = List.of(
                new Dish("Pasta", Dish.DishType.MAIN_COURSE, 2, 100),
                new Dish("Water", Dish.DishType.DRINK, 1, 20)
        );
        assertEquals(220.00, OrderValidator.validateAndCalculateTotal(order), 0.01);
    }

    @Test
    void testOrderWith10PercentDiscount() {
        List<Dish> order = List.of(
                new Dish("Pasta", Dish.DishType.MAIN_COURSE, 3, 200) // 600 -> 10% discount -> 540
        );
        assertEquals(540.00, OrderValidator.validateAndCalculateTotal(order), 0.01);
    }

    @Test
    void testOrderWith10And5PercentDiscounts() {
        List<Dish> order = List.of(
                new Dish("Pasta", Dish.DishType.MAIN_COURSE, 1, 200),
                new Dish("Steak", Dish.DishType.MAIN_COURSE, 1, 150),
                new Dish("Chicken", Dish.DishType.MAIN_COURSE, 1, 160),
                new Dish("Soup", Dish.DishType.APPETIZER, 1, 50),
                new Dish("Salad", Dish.DishType.APPETIZER, 1, 40),
                new Dish("Cake", Dish.DishType.DESSERT, 1, 30) // Total 630 -> 10% -> 567 -> 5% -> 538.65
        );
        assertEquals(538.65, OrderValidator.validateAndCalculateTotal(order), 0.01);
    }
}