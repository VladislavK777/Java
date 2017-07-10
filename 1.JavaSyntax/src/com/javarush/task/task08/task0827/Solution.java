package com.javarush.task.task08.task0827;

import java.util.*;
/*
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date yearDate = new Date(date);
        Date date1 = new Date(date);
        yearDate.setDate(1);
        yearDate.setMonth(0);

        long difMin = date1.getTime() - yearDate.getTime();
        long myMin = 24 * 60 * 60 * 1000;

        int dayCount = (int) (difMin/myMin);

        return (dayCount % 2 == 0);
    }
}
