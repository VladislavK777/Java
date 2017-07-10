package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 12, 15, 5, 17, 20};
        System.out.println(Arrays.toString(sort(array)));
    }

    public static Integer[] sort(Integer[] array) {

        Arrays.sort(array);
        final double median;
        if (array.length % 2 != 0) {
            median = array[array.length / 2];
        } else {
            median = (array[(array.length / 2 - 1)] + array[(array.length / 2)]) / 2d;
        }

        Arrays.sort(array, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) return 0;
                if (Math.abs(Double.valueOf(o1) - median) - Math.abs(Double.valueOf(o2) - median) > 0) {
                    return 1;
                } else if (Math.abs(Double.valueOf(o1) - median) - Math.abs(Double.valueOf(o2) - median) < 0) {
                    return -1;
                }
                return 0;
            }
        });
        return array;
    }
}
