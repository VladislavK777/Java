package com.javarush.task.task14.task1408;

/**
 * Created by Vladislav.Klochkov on 10.05.2017.
 */
public class MoldovanHen extends Hen {


    @Override
    int getCountOfEggsPerMonth() {
        return 2;
    }
    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
