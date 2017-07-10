package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> list = new HashMap<String, String>();
        list.put("Иванов2", "Петр");
        list.put("Петров", "Николай");
        list.put("Иванов", "Константин");
        list.put("Тулев", "Владимир");
        list.put("Басков", "Николай");
        list.put("Сидоров", "Иван");
        list.put("Цивинский", "Артур");
        list.put("Волокитин", "Дмитрий");
        list.put("Иванов3", "Сергей");
        list.put("Крылов", "Владимир");

        return list;
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
        for (Map.Entry<String, String> pair: map.entrySet()) {
            String value = pair.getValue();
            if (value.equals(name)) {
                count++;
            }
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        for (Map.Entry<String, String> pair: map.entrySet()) {
            String key = pair.getKey();
            if (key.equals(lastName)) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
