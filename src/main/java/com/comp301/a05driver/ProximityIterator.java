package com.comp301.a05driver;

import java.util.NoSuchElementException;

public class ProximityIterator {

    public ProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int proximityRange) {
        if (!driverPool.iterator().hasNext()) {
            throw new NoSuchElementException();
        } else {
            nextDriver(driverPool, clientPosition, proximityRange);
        }
    }
    private boolean nextDriver(Iterable<Driver> driverPool, Position clientPosition, int ProximityRange) {
        driverPool.iterator().next();
        Position x = driverPool.iterator().next().getVehicle().getPosition();
        int y = clientPosition.getManhattanDistanceTo(x);
        if (y <= ProximityRange) {
            return true;
        } else {
            nextDriver(driverPool,clientPosition,ProximityRange);
        }
        return false;
    }
   /* private boolean nextDriver(Iterable<Driver> driverPool, Position clientPosition, int ProximityRange){
        driverPool.iterator().next();
        while (driverPool.iterator().hasNext()) {
            if (clientPosition.getManhattanDistanceTo(driverPool.iterator().next().getVehicle().getPosition()) <= ProximityRange) {
                Iterable<Driver> x = driverPool;
                return true;
            } else {
                driverPool.iterator().next();
            }
        }
        return false;
    }

    */
}
