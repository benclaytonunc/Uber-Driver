package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExpandingProximityIterator implements Iterator<Driver> {
    Iterable<Driver> driverPool;
    Iterator<Driver> driver;
    Driver driverAfter;
    Position clientPosition;
    int expansionStep;
    public ExpandingProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int expansionStep) {
        if (driverPool == null || clientPosition == null || expansionStep == 0){
            throw new IllegalArgumentException("wrong arg.");
        }
        driver = driverPool.iterator();
        driverAfter = null;
        this.driverPool = driverPool;
        this.clientPosition = clientPosition;
        this.expansionStep = expansionStep;
    }
    @Override
    public boolean hasNext() {
        if (driverAfter == null) {
            this.DriverNarrower();
        }
        return driverAfter != null;
    }

    @Override
    public Driver next() {
        boolean tf = this.hasNext();
        if (!tf) {
            throw new NoSuchElementException("no elements found.");
        } else {
            Driver nextDriver = driverAfter;
            driverAfter = null;
            return nextDriver;
        }
    }

    private void DriverNarrower() {
        if (driverAfter == null) {
            while (driver.hasNext()) {
                Driver woman = driver.next();
                Position womanPos = woman.getVehicle().getPosition();
                int dist = clientPosition.getManhattanDistanceTo(womanPos);
                if (dist <= 1) {
                    driverAfter = woman;
                }
            }
            driver = driverPool.iterator();
            while (driver.hasNext()) {
                Driver woman = driver.next();
                Position womanPos = woman.getVehicle().getPosition();
                int dist = clientPosition.getManhattanDistanceTo(womanPos);
                if (dist > 1 & dist <= (1 + expansionStep)) {
                    driverAfter = woman;
                }
            }
            driver = driverPool.iterator();
            while (driver.hasNext()) {
                Driver woman = driver.next();
                Position womanPos = woman.getVehicle().getPosition();
                int dist = clientPosition.getManhattanDistanceTo(womanPos);
                if (dist > (1+expansionStep) & dist <= (1 + (2*expansionStep))) {
                    driverAfter = woman;
                }
            }

        }

    }
}
