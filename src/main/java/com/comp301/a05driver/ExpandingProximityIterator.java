package com.comp301.a05driver;

import java.util.Iterator;

public class ExpandingProximityIterator implements Iterator<Driver> {
    Iterable<Driver> driverPool;
    Iterator<Driver> driver;
    Position clientPosition;
    int expansionStep;
    public ExpandingProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int expansionStep) {
        if (driverPool == null || clientPosition == null || expansionStep == 0){
            throw new IllegalArgumentException("wrong arg.");
        }
        driver = driverPool.iterator();
        this.driverPool = driverPool;
        this.clientPosition = clientPosition;
        this.expansionStep = expansionStep;
    }
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Driver next() {
        return null;
    }

    private void DriverNarrower() {

    }
}
