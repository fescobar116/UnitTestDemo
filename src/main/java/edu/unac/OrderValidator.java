package edu.unac;

import java.util.List;

public class OrderValidator {
    public static double validateAndCalculateTotal(List<Dish> order) {
        if (order == null || order.isEmpty()) {
            throw new IllegalArgumentException("The order cannot be empty.");
        }

        double total = 0;
        boolean hasMainCourse = false;
        int uniqueDishes = order.size();

        for (Dish dish : order) {
            validateDish(dish);
            if (dish.type == Dish.DishType.MAIN_COURSE) {
                hasMainCourse = true;
            }
            total += dish.quantity * dish.price;
        }

        if (!hasMainCourse) {
            throw new IllegalArgumentException("The order must contain at least one main course dish.");
        }

        if (total > 500) {
            total *= 0.90;
        }
        if (uniqueDishes > 5) {
            total *= 0.95;
        }

        return total;
    }

    private static void validateDish(Dish dish) {
        if (dish.name == null || dish.name.isBlank()) {
            throw new IllegalArgumentException("The dish name cannot be empty.");
        }
        if (dish.quantity < 1) {
            throw new IllegalArgumentException("The dish quantity must be at least 1.");
        }
        if (dish.price <= 0) {
            throw new IllegalArgumentException("The dish price must be positive.");
        }
    }
}
