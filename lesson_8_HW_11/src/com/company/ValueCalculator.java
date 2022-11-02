package com.company;

import java.util.Arrays;

public class ValueCalculator {
    private final int arrayLength = 1000000;
    private Float[] array = new Float[arrayLength];
    private final int halfArrayLength = arrayLength / 2;

    public void doCalc() throws InterruptedException {
        long start = System.currentTimeMillis();
        Float[] arraysHalf1 = new Float[halfArrayLength];
        Float[] arraysHalf2 = new Float[halfArrayLength];

        Arrays.setAll(array, n -> array[n] = 1F);
        System.arraycopy(array, 0, arraysHalf1, 0, halfArrayLength);
        System.arraycopy(array, halfArrayLength, arraysHalf2, 0, halfArrayLength);

        Thread thread1 = new Thread(new CalculationThread(arraysHalf1));
        Thread thread2 = new Thread(new CalculationThread(arraysHalf2));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.arraycopy(arraysHalf1, 0, array, 0, halfArrayLength);
        System.arraycopy(arraysHalf2, 0, array, halfArrayLength, halfArrayLength);

        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    public static class CalculationThread implements Runnable {
        Float[] floats;

        public CalculationThread(Float[] floats) {
            this.floats = floats;
        }

        @Override
        public void run() {
            for (int i = 0; i < floats.length; i++) {
                floats[i] = (float) (floats[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }
    }
}

