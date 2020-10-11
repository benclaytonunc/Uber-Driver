package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class ProximityIterator implements Iterator<Driver> {
    Iterable<Driver> driverPool;
    Iterator<Driver> driver;
    Driver driverAfter;
    Position clientPosition;
    int proximityRange;
    public ProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int proximityRange) {
        if (driverPool == null || clientPosition == null || proximityRange == 0) {
            throw new IllegalArgumentException("no arg");
        }
        driver = driverPool.iterator();
        driverAfter = null;
        this.driverPool = driverPool;
        this.clientPosition = clientPosition;
        this.proximityRange = proximityRange;
       // driver.hasNext();
    }

    @Override
    public boolean hasNext() {
        if (driverAfter == null) {
            this.addNextDriver();
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

    private void addNextDriver() {
        if(driverAfter == null) {
            boolean exists = false;
            while(driver.hasNext() & !exists) {
                Driver woman = driver.next();
                Position womanPos = woman.getVehicle().getPosition();
                int dist = clientPosition.getManhattanDistanceTo(womanPos);
                if (dist <= proximityRange) {
                    driverAfter = woman;
                    exists = true;
                }
            }
        }
    }
}
