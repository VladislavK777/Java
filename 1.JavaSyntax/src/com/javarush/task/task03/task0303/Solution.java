package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(100, 1.16));
        System.out.println(convertEurToUsd(254, 1.16));
        //напишите тут ваш код
    }

    public static double convertEurToUsd(int eur, double course) {
        double dollar;
        dollar = eur * course;
        return dollar;
        //напишите тут ваш код
    }
}
