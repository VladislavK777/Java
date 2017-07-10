package com.javarush.task.task14.task1418;

import java.util.LinkedList;
import java.util.List;

/* 
Исправь 4 ошибки
*/

public class Solution {
    public static void main(String[] args) {
        List<Number> list1 = new LinkedList<Number>();
        List<Number> list = initList(list1);
        printListValues(list);
        processCastedObjects(list);
    }
    static List<Number> initList(List<Number> list) {
        list.add(new Double(1000f));
        list.add(new Float(-90/-3));
        return list;
    }

    static void printListValues(List<Number> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void processCastedObjects(List<Number> list) {
        for (Number object : list) {
            //Исправь 2 ошибки
            if (object instanceof Float) {
                Float a = (Float) object;
                System.out.println("Is float value defined? " + !(a.isNaN()));
            } else if (object instanceof Double) {
                Double a = (Double) object;
                System.out.println("Is double value infinite? " + a.isInfinite());
            }
        }
    }
}
