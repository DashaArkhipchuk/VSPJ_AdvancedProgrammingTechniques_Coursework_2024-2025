package Main;

/**
 * Represents a tank with a capacity and current volume.
 * Provides safe methods to add or remove liquid,
 * ensuring that the tank does not overflow or go below zero.
 */
public class Tank {
    private double capacity;
    private double currentVolume;

    /**
     * Creates a tank with the specified capacity.
     * Initially, the tank is empty.
     * @param capacity Maximum capacity of the tank.
     */
    public Tank(double capacity) {
        this.capacity = capacity;
        this.currentVolume = 0;
    }

    /**
     * Adds the specified volume of liquid to the tank.
     * If the added volume exceeds capacity, it is capped at maximum.
     * @param volume The volume to add.
     */
    public void add(double volume) {
        currentVolume += volume;
        if (currentVolume > capacity) {
            currentVolume = capacity;
        }
    }

    /**
     * Removes the specified volume of liquid from the tank.
     * If the removed volume exceeds current content, it is reduced to zero.
     * @param volume The volume to remove.
     */
    public void remove(double volume) {
        currentVolume -= volume;
        if (currentVolume < 0) {
            currentVolume = 0;
        }
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