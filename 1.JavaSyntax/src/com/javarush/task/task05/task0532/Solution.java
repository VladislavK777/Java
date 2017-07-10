package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int o = Integer.parseInt(reader.readLine());
            list.add(o);
        }
        int maximum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (maximum < list.get(i)) {
                maximum = list.get(i);
            }
        }
        //напишите тут ваш код

        System.out.println(maximum);
    }
}
