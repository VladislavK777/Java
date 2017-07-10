package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        int max = 1;
        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(reader.readLine());
            list.add(a);
        }
        for (int i = 0; i < 9; i++) {
           if (list.get(i) == list.get(i + 1))  {
               count++;
           } else {
               count = 1;
           }
            if (count > max) {
                max = count;
            }
        }
        //System.out.println(countList);
        System.out.println(max);
        //напишите тут ваш код

    }
}