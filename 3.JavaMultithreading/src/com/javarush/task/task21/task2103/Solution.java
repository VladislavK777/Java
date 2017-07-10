package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    static class  Дробь {
        private int числитель;
        private int знаменатель;

        public Дробь(int числитель, int знаменатель) {
            this.числитель = числитель;
            this.знаменатель = знаменатель;
        }

        public boolean equals(Object obj) {
            if (obj == null)
                return false;

            if (obj.getClass() != this.getClass())
                return false;

            Дробь other = (Дробь) obj;
            return this.числитель * other.знаменатель == this.знаменатель * other.числитель;
        }

        public int hashCode()
        {
            return числитель/знаменатель + знаменатель/числитель;
        }
    }
    public static void main(String[] args) {
        Дробь one = new Дробь(2,3);
        Дробь two = new Дробь(3,4);
        System.out.println(one.equals(two));
        System.out.println(one.hashCode() == two.hashCode());


    }
}
