package com.javarush.task.task09.task0919;


/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
        try {
            divisionByZero();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    static void divisionByZero ()
    {
        int z = 15/0;
        System.out.println(z);
    }
}
