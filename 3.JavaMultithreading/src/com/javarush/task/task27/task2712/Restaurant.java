package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Vladislav.Klochkov on 23.06.2017.
 */
public class Restaurant {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        Tablet tablet = new Tablet(5);
        //Tablet tablet1 = new Tablet(4);
        Cook cook = new Cook("Amigo");
        //Cook cook1= new Cook("Papa");
        DirectorTablet directorTablet = new DirectorTablet();
        Waiter waiter = new Waiter();
        tablet.addObserver(cook);
        //tablet1.addObserver(cook1);
        cook.addObserver(waiter);
        //cook1.addObserver(waiter);
        tablet.createOrder();
        //tablet1.createOrder();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}
