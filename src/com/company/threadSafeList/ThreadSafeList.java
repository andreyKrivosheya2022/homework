package com.company.threadSafeList;

import java.util.ArrayList;

public class ThreadSafeList {
    private final ArrayList<Integer> arrayList = new ArrayList<>();

    public synchronized void add(int index, Integer number) {
            arrayList.add(index, number);
    }

    public synchronized void remove(int index) {
            if (index >= 0 && index < arrayList.size()) {
                arrayList.remove(index);
            } else throw new IndexOutOfBoundsException ("Index " + index + "is out of list`s size");
    }

    public synchronized void get(int index) {
            if (index >= 0 && index < arrayList.size()) {
                System.out.println(arrayList.get(index));
            } else throw new IndexOutOfBoundsException ("Index " + index + " is out of list`s size");
    }
}

class ArraySafeList implements Runnable {
    ThreadSafeList threadSafeList = new ThreadSafeList();
    private final Integer number;
    private final int index;

    public ArraySafeList(int index,Integer number) {
        this.index = index;
        this.number = number;
    }

    @Override
    public void run() {
        threadSafeList.add(index,number);
        threadSafeList.get(index);
        threadSafeList.remove(index);
    }
}
