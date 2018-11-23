package com.epam.algorithms;

import java.util.Arrays;

/**
 * A Bubble sort realization class.
 */
public class BubbleSort {

    public int[] sort(int[] arr) {
        int[] innerArray = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < innerArray.length; i++) {
            for (int j = i + 1; j < innerArray.length; j++) {
                if (innerArray[i] > innerArray[j]) {
                    int tmp = innerArray[i];
                    innerArray[i] = innerArray[j];
                    innerArray[j] = tmp;
                }
            }
        }
        return innerArray;
    }
}