package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
            System.out.println(thePlanet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        thePlanet = null;
        String n = reader.readLine();
        if (n.equals(Planet.SUN)) {
           thePlanet = Sun.getInstance();
        } else if (n.equals(Planet.EARTH)) {
            thePlanet = Earth.getInstance();
        } else if (n.equals(Planet.MOON)) {
            thePlanet = Moon.getInstance();
        } else {
            thePlanet = null;
        }
        // implement step #5 here - реализуйте задание №5 тут
    }
}
