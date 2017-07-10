package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Date;
import java.util.List;

/**
 * Created by Vladislav.Klochkov on 26.06.2017.
 */
public class CookedOrderEventDataRow implements EventDataRow {
    private String cookName;
    private int cookingTimeSeconds;
    private List<Dish> cookingDishs;
    private String tabletName;
    private Date currentDate;

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs)
    {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishs = cookingDishs;
        currentDate = new Date();
    }

    public String getCookName() {
        return cookName;
    }

    public int getCookingTimeSeconds() {
        return cookingTimeSeconds;
    }

    public List<Dish> getCookingDishs() {
        return cookingDishs;
    }

    public String getTabletName() {
        return tabletName;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

    @Override
    public int getTime() {
        return getCookingTimeSeconds();
    }

    @Override
    public Date getDate() {
        return getCurrentDate();
    }
}
