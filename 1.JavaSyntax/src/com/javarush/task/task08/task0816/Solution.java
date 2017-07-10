package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Петров", new Date("JUNE 1 1980"));
        map.put("Иванов", new Date("JULY 2 1988"));
        map.put("Селяев", new Date("AUGUST 34 1976"));
        map.put("Маркони", new Date("JANUARY 1 1880"));
        map.put("Царь", new Date("FEBRUARY 1 190"));
        map.put("Пррен", new Date("JULY 1 2000"));
        map.put("Карлин", new Date("JUNE 1 1965"));
        map.put("Цирон", new Date("APRIL 1 1995"));
        map.put("Патрон", new Date("NOVEMBER 1 1992"));
        map.put("Киль", new Date("JUNE 1 1993"));

        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        HashMap<String, Date> copy = new HashMap<String, Date>(map);
        for (HashMap.Entry<String, Date> pair : copy.entrySet()) {
            String key = pair.getKey();
            Date value = pair.getValue();
            if (value.getMonth() > 4 && value.getMonth() < 8) {
                map.remove(key);
            }

        }
        //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
