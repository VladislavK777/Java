package com.javarush.task.task28.task2810.model;

/**
 * Created by vladislav.klochkov on 17.07.2017.
 */
public class Provider {
    Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
