package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vladislav.klochkov on 13.07.2017.
 */
public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> set = new HashSet<>();
        for (String s : strings) {
            set.add(shortener.getId(s));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> set = new HashSet<>();
        for (Long k : keys) {
            set.add(shortener.getString(k));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++) {
            set.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);

        Date dateStartGetIds = new Date();
        Set<Long> ids = getIds(shortener, set);
        Date dateFinishGetIds = new Date();

        long deltaTime = dateFinishGetIds.getTime() - dateStartGetIds.getTime();
        Helper.printMessage(Long.toString(deltaTime));

        Date dateStartGetStrings = new Date();
        Set<String> strs = getStrings(shortener, ids);
        Date dateFinishGetStrings = new Date();

        long deltaTime2 = dateFinishGetStrings.getTime() - dateStartGetStrings.getTime();
        Helper.printMessage(Long.toString(deltaTime2));

        if (set.equals(strs)) {
            Helper.printMessage("Тест пройден.");
        } else {
            Helper.printMessage("Тест не пройден.");
        }

    }
    public static void main(String[] args) {
        StorageStrategy strategy1 = new HashMapStorageStrategy();
        testStrategy(strategy1, 10000);
        StorageStrategy strategy2 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy2, 10000);
    }
}
