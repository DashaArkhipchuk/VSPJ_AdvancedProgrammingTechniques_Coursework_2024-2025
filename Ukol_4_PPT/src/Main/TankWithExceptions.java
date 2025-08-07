package Main;

import Exceptions.*;

/**
 * Represents a tank with capacity and volume tracking.
 * Throws exceptions when trying to overfill or under-empty.
 */
public class TankWithExceptions {
    private double capacity;
    private double currentVolume;

    /**
     * Initializes the tank with the given capacity. Starts empty.
     * @param capacity Maximum capacity of the tank.
     */
    public TankWithExceptions(double capacity) {
        this.capacity = capacity;
        this.currentVolume = 0;
    }

    /**
     * Adds volume to the tank. Throws an exception if it exceeds capacity.
     * @param volume Volume to add.
     * @throws FullTankException if the tank overflows.
     */
    public void add(double volume) throws FullTankException {
        if (currentVolume + volume > capacity) {
            throw new FullTankException("Tank is full!");
        }
        currentVolume += volume;
    }

    /**
     * Removes volume from the tank. Throws an exception if result is negative.
     * @param volume Volume to remove.
     * @throws EmptyTankException if tank underflows.
     */
    public void remove(double volume) throws EmptyTankException {
        if (currentVolume - volume < 0) {
            throw new EmptyTankException("Tank is empty!");
        }
        currentVolume -= volume;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getCurrentVolume() {
        return currentVolume;
    }

    public boolean isEmpty() {
        return currentVolume == 0;
    }

    public boolean isFull() {
        return currentVolume == capacity;
    }
}