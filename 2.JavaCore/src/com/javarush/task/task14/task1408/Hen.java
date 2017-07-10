package com.javarush.task.task14.task1408;

/**
 * Created by Vladislav.Klochkov on 10.05.2017.
 */
public abstract class Hen {
    abstract int getCountOfEggsPerMonth();
    String getDescription() {
        return "Я - курица.";
    }
}
