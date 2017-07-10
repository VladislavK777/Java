package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String s;
        String s1;
        //try {
        s = string.substring(string.indexOf(" "));
        for (int i = 0; i < 4; i++) {
            int index = s.indexOf(" ");
            System.out.println(i + " " + index);
            s = s.substring(s.indexOf(" "));
        }


       // } catch (Exception e) {
       //     throw new TooShortStringException();
       // }
        return s;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
