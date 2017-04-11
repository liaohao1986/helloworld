/**
 * 
 */
package com.huoli.checkin.design.spring.ioc;

public class Human {
    private Car car;

    public void myCarRun() {
        car.run();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}