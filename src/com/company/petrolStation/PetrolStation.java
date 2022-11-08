package com.company.petrolStation;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PetrolStation {
    private static final Object lock = new Object();
    private volatile static Float amount = 1000f;
    private final Semaphore semaphore = new Semaphore(3);

    public void doRefuel(Float amountOfFuelNeeded) {
        Random random = new Random();

        try {
            semaphore.acquire();

            boolean isRefuel = false;
            synchronized (lock) {
                if (amount - amountOfFuelNeeded >= 0) {
                    System.out.println("Fuel is now: " + amount +"\nFuel for refuel " + amountOfFuelNeeded + " is replenishing");
                    System.out.println();

                    amount -= amountOfFuelNeeded;
                    isRefuel = true;

                    System.out.println("Fuel for refuel " + amountOfFuelNeeded + " finished replenishing");
                    System.out.println();
                } else
                    throw new IllegalArgumentException("Amount fuel for refuel (" + amountOfFuelNeeded + ") greater than overall fuel (" + amount + ")");
            }
            if(isRefuel) Thread.sleep(random.nextInt(3000, 10000));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }

    }
}

class CustomerReplenish implements Runnable {
    private final Float amountOfFuelNeeded;
    PetrolStation petrolStation = new PetrolStation();

    public CustomerReplenish(Float amountOfFuelNeeded) {
        this.amountOfFuelNeeded = amountOfFuelNeeded;
    }

    @Override
    public void run() {
        petrolStation.doRefuel(amountOfFuelNeeded);
    }
}