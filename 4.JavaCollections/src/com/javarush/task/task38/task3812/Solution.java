package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest firstClass = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (String p : firstClass.fullyQualifiedNames()) {
                System.out.println(p);
            }
           return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest firstClass = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class p : firstClass.value()) {
                System.out.println(p.getSimpleName());
            }
            return true;
        }
        return false;
    }
}
