package com.lab22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

public class Race {
    public static void main(String[] args) {
        int count = 2;
        List<RaceCarRunnable> cars = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(count);
        cars.add((new RaceCarRunnable("BMW", 300, 1000, countDownLatch)));
        cars.add((new RaceCarRunnable("AstonMartin", 300, 1000, countDownLatch)));
        List<Thread> threads1 = cars.stream().map(Thread::new).collect(Collectors.toList());
        startRace(threads1);
        try {
            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish");
    }

    static void startRace(List<Thread> cars) {
        new Thread(new Runnable() {
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
                        r.start();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
