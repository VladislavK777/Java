package com.javarush.task.task08.task0814;

import java.util.*;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        HashSet<Integer> list = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        return list;
        //напишите тут ваш код

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {

        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext())
        {
            int n = iterator.next();
            if (n > 10) {
                iterator.remove();
            }
        }
        return set;
        //напишите тут ваш код
    }

    public static void main(String[] args) {


    }
}
