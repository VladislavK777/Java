package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;/*
Максимальный байт
*/
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(name);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (fileInputStream.available() > 0) {
            int a = fileInputStream.read();
            list.add(a);
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        System.out.println(max);
        fileInputStream.close();
        reader.close();
    }
}
