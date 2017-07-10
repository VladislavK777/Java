package com.javarush.task.task04.task0411;

/* 
Времена года на Терре
*/

public class Solution {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        int[] Zima = {12, 1, 2};
        int[] Vesna = {3, 4, 5};
        int[] Leto = {6, 7, 8};
        int[] Osen = {9, 10, 11};
        for (int i = 0; i < Zima.length; i++) {
            if (month == Zima[i])
                System.out.println("зима");
        }
        for (int j = 0; j < Vesna.length; j++) {
            if (month == Vesna[j])
                System.out.println("весна");
        }
        for (int k = 0; k < Leto.length; k++) {
            if (month == Leto[k])
                System.out.println("лето");
        }
        for (int n = 0; n < Osen.length; n++) {
            if (month == Osen[n])
                System.out.println("осень");
        }
        //::CODE:
    }
}