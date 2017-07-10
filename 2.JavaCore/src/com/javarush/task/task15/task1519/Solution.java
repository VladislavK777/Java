package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Double d = 0.0;
        while (true) {
            String v = reader.readLine();
            if (v.equals("exit")) {
                break;
            }
            try {
                int i = Integer.parseInt(v);
                if (i > 0 && i < 128) {
                    print(Integer.parseInt(v));
                } else if (Integer.parseInt(v) < 0 || Integer.parseInt(v) >= 128) {
                    print(Integer.parseInt(v));
                }
            } catch (NumberFormatException e){
                try {
                    print(Double.parseDouble(v));
                } catch (NumberFormatException e1) {
                    print(v);
                }
            }
        }//напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
