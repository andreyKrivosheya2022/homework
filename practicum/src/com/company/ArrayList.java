package com.company;

class ArrayList implements MyList {
    private static int count = 1;
    private Object[] mass = new Object[count];

    @Override
    public boolean add(Object o) {
        if (count == 1) {
            mass = new Object[count];
            mass[0] = o;
            count++;
        } else {
            Object[] array = new Object[count];
            System.arraycopy(mass, 0, array, 0, count - 1);
            array[count - 1] = o;
            mass = new Object[count];
            System.arraycopy(array, 0, mass, 0, count);
            count++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Object[] result = new Object[count - 1];
        int index = 0;

        System.arraycopy(mass, 0, result, 0, mass.length);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == o) {
                index = i;
            }
        }
        if (index == 0) return false;

        mass = new Object[result.length - 1];
        System.arraycopy(result, 0, mass, 0, index);
        System.arraycopy(result, index + 1, mass, index, result.length - index - 1);
        return true;
    }

    public Object[] toArray() {
        return mass;
    }

    @Override
    public boolean isEmpty() {
        return mass.length == 0;
    }

    @Override
    public int size() {
        return mass.length;
    }

    @Override
    public void clear() {
        count = 1;
        mass = new Object[0];
    }

    @Override
    public Object get(int index) {
        return mass[index];
    }
}