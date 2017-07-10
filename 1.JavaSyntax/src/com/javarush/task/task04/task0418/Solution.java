package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String s1 = reader2.readLine();
        int a = Integer.parseInt(s);
        int b = Integer.parseInt(s1);
        if (a < b || a == b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
        //напишите тут ваш код
    }
}