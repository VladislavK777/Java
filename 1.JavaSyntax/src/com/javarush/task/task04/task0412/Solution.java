package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(s);

        if (n < 0)
            System.out.println(n = n + 1);
        else if (n > 0)
            System.out.println(n = n * 2);
        else
            System.out.println(n);
        //напишите тут ваш код

    }

}