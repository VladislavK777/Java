package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> list = new HashMap<String, Integer>();
        list.put("Иванов2", 100);
        list.put("Петров", 200);
        list.put("Иванов", 250);
        list.put("Тулев", 300);
        list.put("Басков", 1000);
        list.put("Сидоров", 800);
        list.put("Цивинский", 100);
        list.put("Волокитин", 500);
        list.put("Иванов3", 600);
        list.put("Крылов", 400);

        return list;
        //напишите тут ваш код
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
        for (Map.Entry<String, Integer> pair: copy.entrySet()) {
            if (pair.getValue() < 500) {
                map.remove(pair.getKey());
            }
        }
        System.out.println(map);
        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}