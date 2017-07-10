package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String s1 = reader2.readLine();
        int a = Integer.parseInt(s1);
        int i = 0;
        while (i < a) {
            System.out.println(s);
            i++;
        }
        //напишите тут ваш код

    }
}
