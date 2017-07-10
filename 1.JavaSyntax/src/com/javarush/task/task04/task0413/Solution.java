package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        String[] days = {"", "понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int numday = Integer.parseInt(s);

        if (numday < 1 || numday > 7 )
            System.out.println("такого дня недели не существует");
        else
            for (int i = 1; i < days.length; i++) {
                if (numday == i)
                    System.out.println(days[i]);
                }
    }
}
