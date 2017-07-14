package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vladislav.klochkov on 14.07.2017.
 */
public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        Date startTimeIds = new Date();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }
        Date finishTimeIds = new Date();
        return finishTimeIds.getTime() - startTimeIds.getTime();
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        Date startTimeStrings = new Date();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }
        Date finishTimeStrings = new Date();
        return finishTimeStrings.getTime() - startTimeStrings.getTime();
    }

    @Test
    public void testHashMapStorage() {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener1 = new Shortener(hashMapStorageStrategy);
        Shortener shortener2 = new Shortener(hashBiMapStorageStrategy);
        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        Long diff1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        Long diff2 = getTimeForGettingIds(shortener2, origStrings, ids2);
        Assert.assertTrue(diff1 > diff2);

        Long diff3 = getTimeForGettingStrings(shortener1, ids1, new HashSet<String>());
        Long diff4 = getTimeForGettingStrings(shortener2, ids2, new HashSet<String>());
        Assert.assertEquals(diff3, diff4, 30);

    }
}
