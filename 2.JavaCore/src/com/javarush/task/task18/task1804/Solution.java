package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    count++;
                }
            }
            // System.out.println(list.get(i) + " " + count);
            map.put(list.get(i),  count);
        }
        int min = 9999999;
        List<Integer> total = new ArrayList<Integer>();
        for (HashMap.Entry<Integer, Integer> p : map.entrySet()){
            if (p.getValue() < min) {
                min = p.getValue();
            }
            // System.out.println("key " + p.getKey() + " " + p.getValue());
        }
        for (HashMap.Entry<Integer, Integer> p1 : map.entrySet()){
            if (p1.getValue() == min) {
                total.add(p1.getKey());
            }
        }
        for (int i = 0; i < total.size(); i++) {
            System.out.print(total.get(i));
            System.out.print(" ");
        }
        fileInputStream.close();
    }
}
