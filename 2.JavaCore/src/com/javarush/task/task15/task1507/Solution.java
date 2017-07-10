package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(int m, int n, int v) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(v + m + n);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m) {
            System.out.println(m);

    }

    public static void printMatrix(int m, int n, String value, Object v) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, int v, String value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(v + m + n);
            }
            System.out.println("Заполняем объектами String " + value);
        }
    }

    public static void printMatrix(int m, int n) {
        System.out.println(m + n);

    }

    public static void printMatrix(int m, String value) {
        System.out.println(m + value);

    }

    public static void printMatrix(int m, int n, String value, Object v, int a) {
        System.out.println("Заполняем объектами String" + a);
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, int v, String value, int a) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(v + m + n + a);
            }
            System.out.println("Заполняем объектами String " + value + a);
        }
    }
}
