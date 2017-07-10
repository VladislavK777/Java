package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder where = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null) continue;
            if (where.toString().equals(""))
                where.append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
            else
                where.append(" and ").append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
        }
        return where.toString();
    }
}
