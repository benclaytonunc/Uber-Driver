package com.comp301.a05driver;

import java.util.NoSuchElementException;

public class ProximityIterator {

    public ProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int proximityRange) {

        if(!driverPool.iterator().hasNext()) {
            throw new NoSuchElementException();
        } else {
            nextDriver(driverPool, clientPosition, proximityRange);
        }
    }
    private Iterable<Driver> nextDriver(Iterable<Driver> driverPool, Position clientPosition, int ProximityRange){
        while (driverPool.iterator().hasNext()) {
            if (clientPosition.getManhattanDistanceTo(driverPool.iterator().next().getVehicle().getPosition()) <= ProximityRange) {
                Iterable<Driver> x = driverPool;
                return x;
            } else {
                driverPool.iterator().next();
            }
        }
        return null;
    }
}
