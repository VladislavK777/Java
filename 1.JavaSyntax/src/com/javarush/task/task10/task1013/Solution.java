package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private char sex;
        private String city;
        private String type;
        private String address;

        // 1
        public Human(String n) {
            this.name = n;
        }

        // 2
        public Human(String n, int a) {
            this.name = n;
            this.age = a;
        }

        // 3
        public Human(String n, int a, String c) {
            this.name = n;
            this.age = a;
            this.city = c;
        }

        // 4
        public Human(String n, int a, String c, char s) {
            this.name = n;
            this.age = a;
            this.city = c;
            this.sex = s;
        }

        // 5
        public Human(String n, int a, char s, String t) {
            this.name = n;
            this.age = a;
            this.sex = s;
            this.type = t;
        }

        // 6
        public Human(String n, int a, String c, char s, String t, String ad) {
            this.name = n;
            this.age = a;
            this.city = c;
            this.sex = s;
            this.type = t;
            this.address = ad;
        }

        // 7
        public Human(String n, int a, String c, String ad) {
            this.name = n;
            this.age = a;
            this.city = c;
            this.address = ad;
        }

        // 8
        public Human(String c, String ad, String t) {
            this.city = c;
            this.address = ad;
            this.type = t;
        }

        // 9
        public Human(int a, String c, char s, String ad) {
            this.age = a;
            this.city = c;
            this.sex = s;
            this.address = ad;
        }

        // 10
        public Human(char s, String ad) {
            this.sex = s;
            this.address = ad;
        }
    }
}
