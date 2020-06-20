package com.lab22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    public static void main(String[] args) {
        List<RaceCarRunnable> cars = new ArrayList<>();
        cars.add(new RaceCarRunnable("BMW",250,402));
//        cars.add((RaceCarRunnable) new Car("mercedes",255));
        List<Thread> threads = Collections.singletonList(new Thread(String.valueOf(cars)));
        System.out.println(cars);
    }
}
