package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader1.readLine();
        String s2 = reader2.readLine();
        String s3 = reader3.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

        if (max(a, b) < c && a < b) {
            System.out.println(c + " " + b + " " + a);
        }
            else
            System.out.println(c);
    }

    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
}

/*
if (a > b && a > c && b > c) {
        System.out.println(a + " " + b + " " + c);
        } else if (a < b && b > c && a > c) {
        System.out.println(b + " " + a + " " + c);
        } else if (a < b && b > c && a < c) {
        System.out.println(b + " " + c + " " + a);
        } else if (a < b && b < c && a > b) {
        System.out.println(c + " " + a + " " + b);
        } else if (a < b && b < c && a < c) {
        System.out.println(c + " " + b + " " + a);
        }*/
