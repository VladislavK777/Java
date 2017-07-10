package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if (a <= 0){
            throw new NumberFormatException();
        }
        int b = Integer.parseInt(reader.readLine());
        if (b <= 0){
            throw new NumberFormatException();
        }
        System.out.println(getTotalList(getArrayList(a), getArrayList(b)));
    }

    public static ArrayList<Integer> getArrayList(int a) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (double i = 1.0; i <= a; i++) {
            double b = a / i;
            int c = (int) b;
            double num = b - c;
            if (num == 0) {
                list.add((int) i);
            }
        }
        return list;
    }

    public static int getTotalList(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if (a.get(i) == b.get(j)) {
                    list.add(a.get(i));
                }
            }
        }
        int max = 0;
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
