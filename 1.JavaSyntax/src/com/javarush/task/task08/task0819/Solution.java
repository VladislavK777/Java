package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/*
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        for (Cat x : cats) {
            cats.remove(x);
            break;
        }
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> cats = new HashSet<Cat>();
        for (int i = 0; i < 3; i++) {
            cats.add(new Cat());
        }
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        HashSet<Cat> cats1 = new HashSet<Cat>(cats);
        for (Cat x : cats1) {
            System.out.println(x);
        }
    }

    public static class Cat {

    }
    // step 1 - пункт 1
}
