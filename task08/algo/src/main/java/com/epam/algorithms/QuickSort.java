package com.epam.algorithms;

/**
 * A Quick sort realization class. Pivot point is at the middle of an array.
 */
public class QuickSort {
    private int[] array;

    public void sort(int[] arr) {
        this.array = arr;
        quickSort(0, arr.length - 1);
    }

    private void quickSort(int lowerBound, int higherBound) {
        int i = lowerBound;
        int j = higherBound;
        int pivot = array[lowerBound+(higherBound-lowerBound)/2];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        if (lowerBound < j)
            quickSort(lowerBound, j);
        if (i < higherBound)
            quickSort(i, higherBound);
    }

    private void exchangeNumbers(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}