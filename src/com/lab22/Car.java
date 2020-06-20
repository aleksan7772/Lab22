package com.lab22;

public class Car implements Runnable {
    private String name;
    private Integer maxSpeed;

    public Car(String name, Integer maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public Car() {

    }

    @Override
    public void run() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
