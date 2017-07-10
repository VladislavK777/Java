package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {
        ArrayList<Woman> women = new ArrayList<Woman>();
        women.add(new Woman("Катя", "Катина", 18));
        women.add(new Woman("Маша", "Машина",21));
        women.add(new Woman("Катя", "Сакина",5));

        Comparator<Woman> compareByName = new Comparator<Woman>() {
            public int compare(Woman o1, Woman o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        Comparator<Woman> compareByHeight = new Comparator<Woman>() {
            public int compare(Woman o1, Woman o2) {
                return o1.age - o2.age;
            }
        };

        Comparator<Woman> compareBySurname = new Comparator<Woman>() {
            public int compare(Woman o1, Woman o2) {
                return o1.surname.compareTo(o2.surname);
            }
        };

        //Collections.sort(women, compareByHeight);

        CustomizedComparator<Woman> customizedComparator = new CustomizedComparator<Woman>(compareByName, compareBySurname, compareByHeight);
        Collections.sort(women, customizedComparator);
        for (Woman w : women) {
            System.out.println(w.name + " " + w.surname + " " + w.age);
        }
    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (int i = 0; i < comparators.length; i++) {
                result = comparators[i].compare(o1,o2);
                if (result != 0) {
                    break;
                }
            }
            return result;
        }
    }

    public static class Woman
    {
        public String name;
        public String surname;
        public int age;


        public Woman(String name, String surname, int age) {
            this.age = age;
            this.name = name;
            this.surname = surname;
        }

    }
}
