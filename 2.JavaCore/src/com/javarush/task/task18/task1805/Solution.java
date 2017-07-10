package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new TreeMap<Integer,Integer>();
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        int tmp = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        for (Map.Entry<Integer, Integer> p : map.entrySet()) {
            System.out.print(p.getKey());
            System.out.print(" ");
        }
        fileInputStream.close();
    }
}
