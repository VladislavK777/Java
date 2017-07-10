package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[3];
        s[0] = reader1.readLine();
        s[1] = reader2.readLine();
        s[2] = reader3.readLine();
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length; i++) {
            if (Integer.parseInt(s[i]) > 0 && Integer.parseInt(s[i]) != 0 )
                a++;
            else if (Integer.parseInt(s[i]) < 0 && Integer.parseInt(s[i]) != 0 )
                b++;
        }
        System.out.println("количество отрицательных чисел: " + b);
        System.out.println("количество положительных чисел: " + a);

    }
}
