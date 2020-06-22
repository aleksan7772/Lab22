package com.lab22;

import java.util.Random;

import static java.lang.Thread.sleep;

public class RaceCarRunnable extends Car {
    private Integer passed; // пройденная дистанция
    private Integer distance; // длина трассы
    private volatile boolean isFinish; // флаг завершения гонки


    public RaceCarRunnable(String name, Integer maxSpeed, Integer distance) {
        super(name, maxSpeed);
        this.distance = distance;
    }

    public RaceCarRunnable() {
        super();
    }

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

    void print() {
        System.out.println(getName() + " => " + " speed: " + getRandomSpeed() + " progress: " + getPassed() + '/' + getDistance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RaceCarRunnable that = (RaceCarRunnable) o;

        if (isFinish != that.isFinish) return false;
        if (passed != null ? !passed.equals(that.passed) : that.passed != null) return false;
        return distance != null ? distance.equals(that.distance) : that.distance == null;
    }

    @Override
    public int hashCode() {
        int result = passed != null ? passed.hashCode() : 0;
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        result = 31 * result + (isFinish ? 1 : 0);
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
                sleep(1000);
                if (passed >= distance)
                    isFinish = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
