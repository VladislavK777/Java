package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        double sum = 0.0;
        int count = 0;
        for (; true;) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            int a =  Integer.parseInt(s);
            if (s.equals("-1")) {
                break;
            }
            sum = sum + a;
            count++;
        }
        System.out.println(sum / count);
        //напишите тут ваш код
    }
}

