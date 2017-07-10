package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //дедушка
        String GF = reader.readLine();
        Cat grandFather = new Cat(GF);

        //бабушка
        String GM = reader.readLine();
        Cat grandMother = new Cat(GM);

        //папа
        String F = reader.readLine();
        Cat father = new Cat(F, 1, grandFather);

        //мама
        String M = reader.readLine();
        Cat mother = new Cat(M, 2, grandMother);

        //сын
        String S = reader.readLine();
        Cat sun = new Cat(S, father, mother);

        //дочь
        String D = reader.readLine();
        Cat daughter = new Cat(D, father, mother);

        System.out.println(grandFather);
        System.out.println(grandMother);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(sun);
        System.out.println(daughter);

    }

    public static class Cat {
        private String name;
        private Cat parent;
        private Cat parent1;
        private int type;


        Cat(String name) {
            this.name = name;
        }

        Cat(String name, int t, Cat parent) {
            this.name = name;
            this.parent = parent;
            this.type = t;
        }

        Cat(String name, Cat parent, Cat parent1) {
            this.name = name;
            this.parent = parent;
            this.parent1 = parent1;
        }

        @Override
        public String toString() {
            if (parent == null)
                return "Cat name is " + name + ", no mother, no father";
            else if (parent != null && parent1 == null && type == 1)
                return "Cat name is " + name + ", no mother, father is " + parent.name;
            else if (parent != null && parent1 == null && type == 2)
                return "Cat name is " + name + ", mother is " + parent.name + ", no father";
            else if (parent != null && parent1 != null)
                return "Cat name is " + name + ", mother is " + parent1.name + ", father is " + parent.name;
            else
                return null;
        }
    }
}
