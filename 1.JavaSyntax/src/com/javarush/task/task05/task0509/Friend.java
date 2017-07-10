package com.javarush.task.task05.task0509;

/* 
Создать класс Friend
*/

public class Friend {
    private String name;
    private int age;
    private char sex;

    public void initialize(String n) {
        name = n;
    }

    public void initialize(String n, int a) {
        name = n;
        age = a;
    }

    public void initialize(String n, int a, char s) {
        name = n;
        age = a;
        sex = s;
    }
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
