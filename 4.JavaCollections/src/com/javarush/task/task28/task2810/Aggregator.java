package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;

/**
 * Created by vladislav.klochkov on 17.07.2017.
 */
public class Aggregator {
    public static void main(String[] args) throws IllegalAccessException {
        Strategy strategy = null;
        Provider provider = new Provider(strategy);
        Controller controller = new Controller(provider);
        System.out.println(controller.toString());

    }
}
