package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        double n = Double.parseDouble(s);
        double g = 0.0;
        double y = 3.0;
        double r = 4.0;
        int p = 5;
        for (int i = 0; i < 12; i++) {
            if (n < p) {
                if (n >= g && n < y)
                    System.out.println("зелёный");
                else if (n >= y && n < r)
                    System.out.println("желтый");
                else
                    System.out.println("красный");
                break;
            } else {
                g = g + 5.0;
                y = y + 5.0;
                r = r + 5.0;
                p = p + 5;
            }
        }
    }
}