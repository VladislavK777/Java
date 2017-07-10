package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav.Klochkov on 23.06.2017.
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Выберите блюдо:");
        while(true) {
            String select = readString();
            if (select.equalsIgnoreCase("exit")) {
                break;
            }
            if (select.isEmpty()) {
                writeMessage("Блюдо не выбрано.");
                continue;
            }
            boolean found = false;
            for (Dish d : Dish.values()) {
                if (d.name().equalsIgnoreCase(select)) {
                    list.add(d);
                    found = true;
                }
            }
            if (!found) {
                writeMessage("Такого блюда нет!");
            }
        }
        return list;
    }


}
