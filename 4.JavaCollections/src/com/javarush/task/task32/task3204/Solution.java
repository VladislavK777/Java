package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;

/*
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }

    }

    public static ByteArrayOutputStream getPassword() {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 8; i++) {
            int r = (int) (Math.random() * 3);
            switch (r) {
                case 0:
                    outputStream.write((int)random_1());
                    break;
                case 1:
                    outputStream.write((int)random_2());
                    break;
                case 2:
                    outputStream.write((int)random_3());
                    break;
            }
        }
        if ((Pattern.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8})", outputStream.toString()))) return outputStream;
        else return getPassword();
    }

    public static long random_1() {
        int max = 90 - 65;
        int min = 65;
        final double random = Math.random();
        return Math.round((random * max) + min);
    }

    public static long random_2() {
        int max = 122 - 97;
        int min = 97;
        final double random = Math.random();
        return Math.round((random * max) + min);
    }

    public static long random_3() {
        int max = 57 - 48;
        int min = 48;
        final double random = Math.random();
        return Math.round((random * max) + min);
    }
}