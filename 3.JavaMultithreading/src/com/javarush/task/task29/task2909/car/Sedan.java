package com.javarush.task.task29.task2909.car;

/**
 * Created by Vladislav.Klochkov on 08.06.2017.
 */
public class Sedan extends Car {
    private int MAX_SEDAN_SPEED = 120;
    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
