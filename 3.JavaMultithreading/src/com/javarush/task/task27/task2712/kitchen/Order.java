package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * Created by Vladislav.Klochkov on 23.06.2017.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes = ConsoleHelper.getAllDishesForOrder();

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
    }

    public int getTotalCookingTime() {
        int total = 0;
        for (Dish d : dishes) {
            total += d.getDuration();
        }
        return total;
    }

    public Tablet getTablet() {
        return tablet;
    }

    @Override
    public String toString() {
        return dishes.isEmpty() ? "" : "Your order: " + dishes + " of " + tablet + ", cooking time " + getTotalCookingTime() + "min";
    }

    public boolean isEmpty() {
        if (dishes.isEmpty())
            return true;
        else
            return false;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}
