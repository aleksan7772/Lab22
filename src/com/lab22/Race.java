package com.lab22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Race {
    public static void main(String[] args) {
        //        cars.add(new RaceCarRunnable ("BMW",250,402));
//        cars.add((RaceCarRunnable) new Car("mercedes",255));
        List<RaceCarRunnable> cars = new ArrayList<>();
        cars.add((new RaceCarRunnable("BMW", 300, 402)));
        cars.add((new RaceCarRunnable("AstonMartin", 280, 402)));
        List<Thread> threads = List.of(new Thread(String.valueOf(cars)));
        Race.startRace();
    }

    static void startRace(List<Thread> cars) {
        cars.add(new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 3; i >= 1; i++) {
                    System.out.println(i);
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("GO!!!");
                }
            }
        }));
    }
}
