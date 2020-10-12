package com.comp301.a05driver;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExpandingProximityIterator implements Iterator<Driver> {
    Iterable<Driver> driverPool;
    Iterator<Driver> driver;
    Driver driverAfter;
    Position clientPosition;
    int expansionStep;
    private int count = 0;
    private int a = 0;
    private int b = 0;
    public ExpandingProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int expansionStep) {
        if (driverPool == null || clientPosition == null || expansionStep == 0){
            throw new IllegalArgumentException("wrong arg.");
        }
        driver = driverPool.iterator();
        driverAfter = null;
        this.driverPool = driverPool;
        this.clientPosition = clientPosition;
        this.expansionStep = expansionStep;

        while(driver.hasNext()) {
            driver.next();
            a++;
        }
        driver = driverPool.iterator();
    }


    @Override
    public boolean hasNext() {
        return b < a;
    }

    @Override
    public Driver next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        b++;
        while (driverAfter == null) {
            if(driver.hasNext()) {
                Driver ring = driver.next();
                int range = clientPosition.getManhattanDistanceTo(ring.getVehicle().getPosition());

                if ((range > (1 + ((count -1)* expansionStep)) && range <= 1 + (count * expansionStep))) {
                    return ring;
                }
            } else {
                driver = driverPool.iterator();
                count++;
            }
        }
        return null;
    }
}
