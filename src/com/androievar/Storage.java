package com.androievar;

abstract public class Storage {
    Item[] array;

    public int sumWeight(Item[] array) {
        this.array = array;
        int sumArray = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                sumArray = sumArray + array[i].weight;
            }
        }
        return sumArray;
    }
}