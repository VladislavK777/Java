package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

/**
 * Created by Vladislav.Klochkov on 26.06.2017.
 */
public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
