package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Vladislav.Klochkov on 23.06.2017.
 */
public class Tablet extends Observable {
    final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    Order order;

    public Tablet(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Order createOrder() throws IOException {
        try {
            order = new Order(this);
            //AdvertisementManager advertisementManager = new AdvertisementManager(order.getTotalCookingTime() * 3600);
            System.out.println(order.toString());
            try {
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order.toString());
            }
            if (!order.isEmpty()) {
                setChanged();
                notifyObservers(order);
            }
            return order;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }

    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }

}
