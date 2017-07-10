package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader4 = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader1.readLine();
        String s2 = reader2.readLine();
        String s3 = reader3.readLine();
        String s4 = reader4.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        int d = Integer.parseInt(s4);

        if (max(a, b) > max(c, d))
            System.out.println(max(a, b));
        else
            System.out.println(max(c, d));
    }

    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
}
