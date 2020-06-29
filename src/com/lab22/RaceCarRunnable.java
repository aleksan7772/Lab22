package com.lab22;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class RaceCarRunnable extends Car {
    private int passed; // пройденная дистанция
    private int distance; // длина трассы
    private boolean isFinish; // флаг завершения гонки
    private CountDownLatch countDownLatch;


    public RaceCarRunnable(String name, Integer maxSpeed, Integer distance, CountDownLatch countDownLatch) {
        super(name, maxSpeed);
        this.distance = distance;
        this.countDownLatch = countDownLatch;

    }

    public RaceCarRunnable() {
        super();
    }

    static int count = 1;

    public int getRandomSpeed() {
        int min = getMaxSpeed() / 2;
        int max = getMaxSpeed();
        Random random = new Random();
        int speed = max - min;
        int i = random.nextInt(speed + 1);
        return i += min;
    }

    public Integer getPassed() {
        return passed;
    }

    public void setPassed(Integer passed) {
        this.passed = passed;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    void print(int speed) {

        System.out.println(getName() + " => " + " speed: " + speed + " progress: " + getPassed() + '/' + getDistance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceCarRunnable that = (RaceCarRunnable) o;

        if (passed != that.passed) return false;
        if (distance != that.distance) return false;
        if (isFinish != that.isFinish) return false;
        return countDownLatch != null ? countDownLatch.equals(that.countDownLatch) : that.countDownLatch == null;
    }

    @Override
    public int hashCode() {
        int result = passed;
        result = 31 * result + distance;
        result = 31 * result + (isFinish ? 1 : 0);
        result = 31 * result + (countDownLatch != null ? countDownLatch.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RaceCarRunnable{" +
                "passed=" + passed +
                ", distance=" + distance +
                ", isFinish=" + isFinish +
                '}';
    }

    @Override
    public void run() {
        super.run();
        while (!isFinish) {
            try {
                int speed = getRandomSpeed();
                passed += speed;
                print(speed);
                sleep(1000);
                if (passed >= distance) {
                    isFinish = true;
                }

            } catch (InterruptedException e) {
                isFinish = true;
                e.printStackTrace();
            }

        }
        countDownLatch.countDown();
        if (passed >= distance) {
            System.out.println("Place " + count++ + " -> " + getName());

        }
    }
}