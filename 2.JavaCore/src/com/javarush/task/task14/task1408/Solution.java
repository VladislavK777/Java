package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {

    }

    static class HenFactory {
        private int x;

        static Hen getHen(String country) {
            Hen hen = null;
            if (country.equals("Belarus")) {
                hen = new BelarusianHen();
            } else if (country.equals("Ukraine")) {
                hen = new UkrainianHen();
            } else if (country.equals("Russia")) {
                hen = new RussianHen();
            } else if (country.equals("Moldova")) {
                hen = new MoldovanHen();
            }
            //напишите тут ваш код
            return hen;
        }
    }
}
