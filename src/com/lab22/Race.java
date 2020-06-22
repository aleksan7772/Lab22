package com.lab22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import static sun.jvm.hotspot.runtime.PerfMemory.start;

public class Race {
    public static void main(String[] args) {
        //        cars.add(new RaceCarRunnable ("BMW",250,402));
//        cars.add((RaceCarRunnable) new Car("mercedes",255));
        List<RaceCarRunnable> cars = new ArrayList<>();
        cars.add((new RaceCarRunnable("BMW", 300, 402)));
        cars.add((new RaceCarRunnable("AstonMartin", 280, 402)));
        List<Thread> threads = List.of(new Thread(String.valueOf(cars)));

    }

    static void startRace(List<Thread> cars) {
        cars.add(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("3...");
                    sleep(500);
                    System.out.println("2...");
                    sleep(500);
                    System.out.println("1...");
                    sleep(500);
                    System.out.println("GO!!!");
                    for (Thread r : cars) {
                        start();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }));
    }
}
