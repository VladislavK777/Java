package com.javarush.task.task03.task0309;

/* 
Сумма 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        int j = 1;
        for (int i = 2; i < 12; i++) {
            System.out.println(j);
            j += i;
        }
    }
}
