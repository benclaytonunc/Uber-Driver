package com.comp301.a05driver;

public class ProximityIterator {
    int x = 0;

    public boolean ProximityIterator(Iterable<Driver> driverPool, Position clientPosition, int proximityRange) {
        driverPool.iterator().next();
        while (driverPool.iterator().hasNext()) {
            if (proximityRange <= clientPosition.getManhattanDistanceTo(driverPool.iterator().next().getVehicle().getPosition())) {
                return true;
            }
            if (driverPool.iterator().next() == null) {
                return false;
            } else {
                driverPool.iterator().next();
            }

        }
        return false;
    }
}
