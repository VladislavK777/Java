package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> list = new ArrayList();
    int n = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        List<Integer> result = new ArrayList<>();
        List<Integer> totalList = listRecursion(number);
        for (int i = 0; i < totalList.size(); i++) {
            int raz = 1;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    raz *= 10;
                }
            }
            if (totalList.get(i) == 0) {
                continue;
            } else {
                result.add(Integer.parseInt(String.valueOf(totalList.get(i) * raz), 3));
            }
        }

        String r = number + " =";
        StringBuilder stringBuilder = new StringBuilder(r);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) > 0) {
                stringBuilder.append(" + " + result.get(i));
            } else {
                stringBuilder.append(" - " + result.get(i) * (-1));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    public List<Integer> listRecursion(int number) {
        if (number % 3 == 2) {
            list.add(-1);
            number = number / 3 + 1;
        } else if (number % 3 == 1) {
            list.add(1);
            number = number / 3;
        } else if (number % 3 == 0) {
            list.add(0);
            number = number / 3;
        }
        if (number > 0) {
            listRecursion(number);
        }
        return list;
    }
}