package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;

import java.util.Arrays;

/**
 * Created by vladislav.klochkov on 17.07.2017.
 */
public class Controller {
    private Provider[] providers;

    public Controller(Provider... provider) throws IllegalAccessException {
        this.providers = provider;
        if (provider == null) {
            throw new IllegalAccessException();
        }
    }

    @Override
    public String toString() {
        return "Controller{" +
                "provider=" + Arrays.toString(providers) +
                '}';
    }
}
