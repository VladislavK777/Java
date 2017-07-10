package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> list = new HashMap<String, String>();
        list.put("Иванов2", "Петр");
        list.put("Петров", "Николай");
        list.put("Иванов", "Константин");
        list.put("Тулев", "Владимир");
        list.put("Басков", "Николай");
        list.put("Сидоров", "Николай");
        list.put("Цивинский", "Николай");
        list.put("Волокитин", "Дмитрий");
        list.put("Иванов3", "Сергей");
        list.put("Крылов", "Владимир");

        return list;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap<String, String> mapCopy = new HashMap<String, String>(map);
        HashMap<String, String> uniqueNames = new HashMap<String, String>();
        for (Map.Entry<String, String> pair : mapCopy.entrySet()) {
            if (uniqueNames.containsValue(pair.getValue())){
                removeItemFromMapByValue(map, pair.getValue());
            } else {
                uniqueNames.put(pair.getKey(), pair.getValue());
            }
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }

    }

    public static void main(String[] args) {

    }
}
