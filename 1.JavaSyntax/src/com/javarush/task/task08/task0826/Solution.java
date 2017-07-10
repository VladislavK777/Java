package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Пять победителей
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {
        int max = 0;
        for (int i = 1; i < array.length; i++) {
            //k++;
            for (int j = 0; j < array.length + 1; j++) {
                if (array[j] < array[i]) {
                    max = array[i];
                    array[i] = array[j];
                    array[j] = max;

                }
            }
        }
        //напишите тут ваш код
    }
}
